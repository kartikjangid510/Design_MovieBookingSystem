# Movie Booking System — Design Example

A small Java example demonstrating an object-oriented design for a movie booking system.

## Overview

This repository contains a simple design for booking movie tickets, focused on clear separation of responsibilities: shows and seats are modeled independently, pricing and payment are extensible via strategy/interfaces, and booking lifecycle is tracked through a status enum.

## Features

- Manage shows and seats
- Book seats with basic availability checks
- Pluggable pricing strategies (`PricingStrategy`)
- Pluggable payment methods (`PaymentMethod`, e.g. `UPIPayment`)
- Simple booking lifecycle captured by `BookingStatus`

## Key classes (design intent)

- `Main.java` — Example runner / entry point
- `Show.java` — Represents a movie show and its seats
- `Seat.java`, `SeatType.java` — Seat model and types
- `PricingStrategy.java` — Interface for pricing implementations
- `PaymentMethod.java`, `UPIPayment.java` — Payment abstraction and an implementation
- `BookingService.java` — Core booking workflow and validation
- `CinemaManagementService.java` — Managing shows and seat state
- `BookingStatus.java` — Booking lifecycle enum

## Build & Run

Requires Java 11+ (JDK installed).

From the project root run:

```bash
javac *.java
java Main
```

`Main` provides a simple demonstration of creating shows, selecting seats, applying pricing, and processing payment.

## Extending the project

- Add a new payment method by implementing `PaymentMethod`.
- Add a new pricing rule by implementing `PricingStrategy` and plugging it into booking logic.
- Add persistence (database) by replacing in-memory collections in `CinemaManagementService`.

## Notes

This project is intended as a design example rather than a production-ready application. It emphasizes modularity and a small set of extension points.

## Contributing

Feel free to open issues or pull requests for improvements or bug fixes.

## License

No license specified — use as a learning reference.
