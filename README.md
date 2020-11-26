## Blockchain in Java
Simple blockchain for the PepegaCoin cryptocurrency, using no external libraries. Only on one end, though. No p2p network yet.

Has a CLI do create transactions, mine blocks, check balance, etc.

## How to run

`./gradlew run --console plain`

## Class Diagram

![diagram](class-diagram.jpg)

## Future functionality

- Add a peer-to-peer network
- Store transactions in a database rather than an ArrayList.