# API Gateway

## Overview
The API Gateway serves as a single entry point for clients, routing requests to the Storage Service and Analysis Service.

## Launch
Launch app on 8090 port:
```bash
./gradlew bootRun
```

## Features
- **Request Routing** — dynamically forwards API calls to Storage Service and Analysis Service
- **Fallback Handling** — returns a `Service Unavailable` response if downstream services are unreachable
- **Circuit Breaker** — protects against service overloads and failures
- **Retry Logic** — automatically retries failed requests (follows idempotency principle by retrying only GET & POST requests)