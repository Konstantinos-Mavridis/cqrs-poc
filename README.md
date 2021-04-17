# cqrs-poc

Explores the basic concepts of **Command Query Responsibility Segregation** (CQRS). CQRS is about segregating the command and query side of the application architecture. CQRS is based on the Command Query Separation (CQS) principle which was suggested by Bertrand Meyer. CQS suggests that we divide the operations on domain objects into two distinct categories: Queries and Commands - Queries return a result and do not change the observable state of a system, Commands change the state of the system but do not necessarily return a value.

This is achieved, first, by cleanly separating the Command and Query sides of the domain model. Even further, the write and read side of the data store are split, as well, and a mechanism is introduced to keep them in sync.

Based on the [CQRS and Event Sourcing in Java](https://www.baeldung.com/cqrs-event-sourcing-java) tutorial