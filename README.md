````md
# Facturación Microservices — Spring Boot + Spring Cloud + PostgreSQL + Docker Compose

Monorepo de un **sistema de facturación en microservicios** construido con **Spring Boot** y **Spring Cloud** (Config Server, Eureka, API Gateway). Utiliza **PostgreSQL 16** como base de datos y se ejecuta localmente con **Docker Compose**.

**Objetivo del repo:** permitir que cualquier persona (recruiter/reviewer) pueda **clonar y levantar el ecosistema completo en minutos** con comandos reproducibles, incluyendo verificación rápida de que todo está funcionando.

---

## Stack

- Java + Spring Boot
- Spring Cloud:
  - **Eureka** (service discovery)
  - **Config Server** (configuración centralizada)
  - **API Gateway** (entrypoint único)
- PostgreSQL 16
- Docker + Docker Compose

---

## Servicios (docker-compose)

| Servicio | Rol | Puerto |
|---|---|---|
| `postgres` | Base de datos (múltiples DBs) | `${POSTGRES_PORT}` → 5432 |
| `eureka-ms` | Service registry | 8761 |
| `config-ms` | Config Server (perfil `native`) | 8888 |
| `gateway-ms` | API Gateway (entrypoint recomendado) | 8079 |
| `auth-ms` | Autenticación | 8090 |
| `productos-ms` | Catálogo / stock | 8091 |
| `clientes-ms` | Gestión de clientes | 8092 |
| `empleados-ms` | Gestión de empleados | 8093 |
| `sucursales-ms` | Gestión de sucursales | 8094 |
| `facturacion-ms` | Facturación (integra con otros ms) | 8096 |

---

## Arquitectura (alto nivel)

- **Config Server** centraliza configuración y la sirve a los microservicios.
- **Eureka** permite el registro y descubrimiento de servicios.
- **Gateway** expone un punto de entrada único y enruta hacia microservicios.
- Cada microservicio persiste en **su propia base** dentro de PostgreSQL (creadas automáticamente).

```mermaid
flowchart LR
  GW[gateway-ms<br/>API Gateway :8079] --> EUREKA[eureka-ms<br/>Discovery :8761]
  CONFIG[config-ms<br/>Config Server :8888] --> GW

  CONFIG --> AUTH[auth-ms :8090]
  CONFIG --> PROD[productos-ms :8091]
  CONFIG --> CLI[clientes-ms :8092]
  CONFIG --> EMP[empleados-ms :8093]
  CONFIG --> SUC[sucursales-ms :8094]
  CONFIG --> FAC[facturacion-ms :8096]

  AUTH --> DB[(PostgreSQL :5432)]
  PROD --> DB
  CLI --> DB
  EMP --> DB
  SUC --> DB
  FAC --> DB
````

**Notas importantes**

* Dentro de Docker, los servicios se comunican por **nombre de servicio** (ej. `postgres`, `config-ms`, `eureka-ms`).
* Desde tu PC, accedés por `localhost` usando los puertos publicados en el `docker-compose.yml`.

---

## Config Server: modo `native` (sin dependencias externas)

El `config-ms` está configurado para leer desde una carpeta local montada:

* `CONFIG_REPO_URI=file:/config-repo`
* `./config-repo` se monta como volumen en `/config-repo`

**Ventajas para un repo público**

* No depende de repositorios Git externos.
* No requiere tokens/credenciales para traer configuración.
* Clonar → ejecutar → funciona.

---

## Requisitos

* Docker Desktop (incluye Docker Compose)

Verificación rápida:

```bash
docker --version
docker compose version
```

---

## Quickstart (Docker)

### 1) Clonar

```bash
git clone https://github.com/cristianprantera/facturacion-microservices.git
cd facturacion-microservices
```

### 2) Variables de entorno

Este proyecto usa variables para inicializar PostgreSQL.

Crear `.env` a partir del ejemplo:

* **Git Bash / Linux / macOS**

```bash
cp .env.example .env
```

* **PowerShell**

```powershell
Copy-Item .env.example .env
```

Editar `.env` y completar (mínimo):

* `POSTGRES_USER`
* `POSTGRES_PASSWORD`
* `POSTGRES_PORT` (por ejemplo `5432`)

> El contenedor `postgres` expone `${POSTGRES_PORT}:5432`. Si tenés un PostgreSQL local usando 5432, elegí otro puerto (ej: `5433`).

### 3) Levantar el ecosistema

Foreground:

```bash
docker compose up --build
```

Background:

```bash
docker compose up -d --build
```

### 4) Ver estado

```bash
docker compose ps
```

### 5) Ver logs (debug rápido)

```bash
docker compose logs -f --tail=200 config-ms
docker compose logs -f --tail=200 eureka-ms
docker compose logs -f --tail=200 gateway-ms
```

### 6) Apagar

```bash
docker compose down
```

Apagar y borrar volúmenes (incluye DB):

```bash
docker compose down -v
```

---

## Verificación rápida (2–3 minutos)

### 1) Eureka: servicios en UP

Abrir:

* [http://localhost:8761](http://localhost:8761)

Deberías ver registrados (UP):

* `AUTH-MS`, `CLIENTES-MS`, `PRODUCTOS-MS`, `EMPLEADOS-MS`, `SUCURSALES-MS`, `FACTURACION-MS`, `GATEWAY-MS` (el nombre exacto puede variar según `spring.application.name`).

### 2) Config Server: entrega configuración

Probar (según los nombres en `config-repo/`):

* [http://localhost:8888/gateway-ms/default](http://localhost:8888/gateway-ms/default)
* [http://localhost:8888/productos-ms/default](http://localhost:8888/productos-ms/default)
* [http://localhost:8888/clientes-ms/default](http://localhost:8888/clientes-ms/default)

**Tip (Windows PowerShell):** `curl` suele ser alias de `Invoke-WebRequest`.
Usar:

```powershell
irm http://localhost:8888/gateway-ms/default
```

### 3) Health checks (si Actuator está expuesto)

* [http://localhost:8888/actuator/health](http://localhost:8888/actuator/health)

El `docker-compose` incluye healthcheck para `config-ms` vía:

* `http://localhost:8888/actuator/health` debe responder `UP`.

---

## Uso de la API

**Entrada recomendada:** API Gateway

* Base URL: `http://localhost:8079`

Las rutas del Gateway están definidas en `config-repo/` (config centralizada). Para revisar rápidamente el enrutamiento, abrir el archivo de configuración del Gateway dentro de `config-repo/` y buscar `spring.cloud.gateway.routes`.

> Sugerencia para reviewers: validar el enrutamiento consumiendo endpoints a través del Gateway (en lugar de pegarle directo a cada microservicio).

---

## Persistencia / Bases creadas automáticamente

El contenedor de PostgreSQL ejecuta:

* `./docker/init-multiple-dbs.sql` (montado en `/docker-entrypoint-initdb.d/`)

Esto inicializa las bases para cada microservicio (ej: `clientesdb`, `productosdb`, `empleadosdb`, `sucursalesdb`, `facturaciondb`, `authdb`).

---

## Orden de arranque (lo que hace Compose)

El `docker-compose.yml` asegura el orden:

1. `postgres` (con healthcheck)
2. `eureka-ms`
3. `config-ms` (con healthcheck)
4. `gateway-ms` y microservicios (`auth`, `clientes`, `productos`, `empleados`, `sucursales`)
5. `facturacion-ms` (depende además de que los otros ms estén iniciados)

---

## Troubleshooting

### Puerto de PostgreSQL ocupado

Si tenés PostgreSQL local en 5432:

* Cambiar `POSTGRES_PORT` en `.env` a otro (ej. `5433`)
* Reiniciar:

```bash
docker compose down
docker compose up -d --build
```

### Un servicio no aparece en Eureka

* Revisar logs del servicio:

```bash
docker compose logs -f --tail=200 <servicio>
```

* Confirmar que `config-ms` está `healthy`:

```bash
docker compose ps
```

### Errores de conexión a DB dentro de Docker

Dentro de contenedores, la URL debe usar `postgres` (no `localhost`):

* Correcto: `jdbc:postgresql://postgres:5432/...`

---

## Autor

**Cristian Prantera**
Java / Spring Boot — Microservices — Docker — PostgreSQL

```
```
