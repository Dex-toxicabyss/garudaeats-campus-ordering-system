# GarudaEats — Campus Cafeteria Ordering System

A Java console prototype for a campus cafeteria ordering flow. This project was created for an individual Object-Oriented Programming assignment and focuses on classes, constructors, encapsulation, arrays of objects, and method-driven business behavior.

## Features

- Menu management with a fixed capacity of 50 menu items
- Name search and category filtering
- Customer balance top-up and payment validation
- Loyalty points based on purchased items
- Orders with a maximum of 10 items
- Stock checks before adding and completing an order
- Successful, insufficient-balance, and cancelled-order demonstrations
- Private fields across the core domain classes

## Domain model

| Class | Responsibility |
| --- | --- |
| `Kantin` | Stores menu items, creates orders, and summarizes activity |
| `MenuItem` | Represents a menu item, price, category, and stock |
| `Customer` | Holds identity, balance, and loyalty points |
| `Order` | Tracks items, status, total, payment, and stock updates |
| `Main` | Runs the complete demonstration scenario |

## Repository structure

```text
├── MenuItem.java
├── Customer.java
├── Order.java
├── Kantin.java
├── Main.java
├── README.md
└── README-102042500123.pdf
```

## Run locally

The program uses only the Java standard library. With a JDK installed, run:

```bash
javac *.java
java Main
```

## What to look for

The `Main` class intentionally walks through three scenarios: a successful order, an order rejected because the customer balance is insufficient, and a cancelled order. The output also shows menu search, category filtering, stock changes, and customer points.

## Assignment documentation

The accompanying contains the assignment-oriented explanation, class diagram, implementation decisions, demo scenario, and OOP reflection.

## Scope

This is a console-based academic prototype. It does not include a database, web UI, authentication, payment gateway, or concurrent order processing.
## Portfolio evidence

### Project responsibility

Individual academic project focused on the domain model, order lifecycle, customer balance, stock validation, and console demonstration.

### Example workflow

```text
Create menu → Search/filter menu → Create order → Add items
→ Validate stock and balance → Complete or cancel order
```

### Validation scenarios

- Successful order with balance deduction and stock reduction
- Rejected order when customer balance is insufficient
- Cancelled order that does not proceed to payment
- Menu search and category filtering
- Customer loyalty-point update after a completed order

## Limitations

- Data is held in memory and resets on restart.
- The interface is console-only.
- No database, authentication, payment gateway, or concurrent-order handling is included.

## Usage policy

No open-source license is included. This repository is published for portfolio and academic reference; reuse should be requested from the author.
