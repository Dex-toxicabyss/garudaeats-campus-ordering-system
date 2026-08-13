# GarudaEats — Campus Cafeteria Ordering System

GarudaEats is a Java console prototype for a digital campus cafeteria ordering flow. The project was created for **Tugas Individu #1 Pemrograman Berorientasi Objek 2026**, with the brief's required focus on object/class design, array objects, constructor overloading, methods, and encapsulation.

> This repository is deliberately separate from the Week 14 Campus Cafeteria project. The two assignments test different concepts: GarudaEats intentionally uses **no inheritance, abstract class, or interface**, as required by this brief.

## Features

| Feature | Implementation |
| --- | --- |
| Menu management | Up to 50 `MenuItem` objects, searchable by name and filterable by category. |
| Customer wallet | Digital balance top-up, payment validation, and loyalty points. |
| Order flow | Up to 10 menu-item objects per order, with pending, completed, and cancelled states. |
| Stock accuracy | Stock only decreases after a successful payment. |
| Demo cases | One successful order, one insufficient-balance order, and one cancelled order. |
| Encapsulation | Every field in `MenuItem`, `Customer`, `Order`, and `Kantin` is private. |

## Required class structure

```text
garudaeats-campus-ordering-system/
├── MenuItem.java
├── Customer.java
├── Order.java
├── Kantin.java
├── Main.java
├── README-102042500123.pdf
└── README.md
```

## Run locally

The program uses only the Java standard library. Compile and run from the repository root:

```bash
javac *.java
java Main
```

## Assignment documentation

The required submission document is included as [`README-102042500123.pdf`](README-102042500123.pdf). It contains the student identity, system description, class diagram, implementation decisions, demo scenario, and OOP reflection required by the brief.

## Academic integrity note

Use this repository as material you can explain confidently. The assignment states that submitted code may be audited; review each class, method, and scenario before using it for assessment.
