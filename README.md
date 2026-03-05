# DevOps GitOps Demo – Spring Boot on Kubernetes
GitOps-based CI/CD pipeline deploying a Spring Boot application to Kubernetes with monitoring and alerting.

![CI](https://github.com/mahmoudghanem1/new-web/actions/workflows/ci.yml/badge.svg)

![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?logo=kubernetes&logoColor=white)
![ArgoCD](https://img.shields.io/badge/ArgoCD-EF7B4D?logo=argo&logoColor=white)
![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?logo=prometheus&logoColor=white)
![Grafana](https://img.shields.io/badge/Grafana-F46800?logo=grafana&logoColor=white)
![Spring Boot](https://img.shields.io/badge/SpringBoot-6DB33F?logo=springboot&logoColor=white)
This project demonstrates a complete DevOps workflow using:

* Docker
* GitHub Actions
* Kubernetes
* ArgoCD
* Prometheus
* Grafana

The goal is to show how an application can be automatically built, deployed, monitored and alerted.

---

# Architecture

```mermaid
flowchart TD

A[Developer Push Code] --> B[GitHub Repository]

B --> C[GitHub Actions CI]
C --> D[Build Docker Image]
D --> E[Push Image to Docker Hub]

E --> F[Update Kubernetes Deployment]

F --> G[ArgoCD GitOps]

G --> H[Kubernetes Cluster]

H --> I[Spring Boot Application]

I --> J[Prometheus Metrics]

J --> K[Grafana Dashboard]

J --> L[Prometheus Alerts]
```

---

# Features

* Automated CI/CD pipeline
* Docker image build and push
* GitOps deployment with ArgoCD
* Kubernetes deployment
* Prometheus monitoring
* Grafana dashboards
* Alert rules for application health

---

# Project Structure

```
new-web
│
├── .github/workflows
│   └── ci.yml
│
├── k8s
│   ├── app
│   │   ├── deployment.yml
│   │   └── service.yml
│   │
│   └── monitoring
│       ├── service-monitor.yaml
│       └── app-alerts.yaml
│
├── src
│
├── Dockerfile
└── README.md
```

---

# CI/CD Pipeline

1️⃣ Developer pushes code to GitHub
2️⃣ GitHub Actions builds Docker image
3️⃣ Image pushed to Docker Hub
4️⃣ Deployment manifest updated
5️⃣ ArgoCD detects change
6️⃣ Kubernetes updates the application

---

# Monitoring

Prometheus collects metrics from:

```
/actuator/prometheus
```

Metrics are discovered using **ServiceMonitor**.

---

# Grafana Dashboard

Example request rate panel:

![Grafana Dashboard](docs/grafana-dashboard.png)

---

# Example Prometheus Query

```
sum(rate(http_server_requests_seconds_count[1m]))
```

This query shows the **request rate per second**.

---

# Alerts

Example alert rules:

Application Down

```
up{job="new-web-service"} == 0
```

High Error Rate

```
sum(rate(http_server_requests_seconds_count{status!~"2.."}[1m])) > 1
```

---

# Author

Mahmoud Ghanem

DevOps learning project demonstrating GitOps deployment using Kubernetes.
