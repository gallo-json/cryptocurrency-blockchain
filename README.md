# Blockchain for a Cryptocurrency

A blockchain implementation in Java for a cryptocurrency. The blockchain is modeled after the Bitcoin.

## Date

Late October of 2020. 10th grade.

## How does it work?

It is a command line interface over the blockchain to:

- Be either a miner or just a listening node (pulling the blockchain real time, but not mining)
- Mine the pending transactions into a block
- Make a transaction
- View blockchain
- View your balance

## Tech Stack

- Java Programming Language & OOP (inheritance)
- Gradle

## Specs

I tried to make this cryptocurrency as robust to my abilities. This included signing transactions, validating blocks in a chain, and a basic P2P network.

### Keys

- secp256k1 key cryptography
- SHA256withECDSA transaction signature algorithm

### Blockchain

- Blocks are stored in an `ArrayList`
- Blocks hashed with SHA256 algorithm
- Blocks mined like in Bitcoin (specified number of zeros at the beginning of hash)

### Peer to peer network

- Only on LAN (localhost)
- Can connect and listen to other peers, assigning you a port
- Miners can broadcast newly mined blocks to other nodes (only full nodes, not other miners, for now)

## How to run

`./gradlew run --console plain`

## Useful links

Useful links that helped guide me:

- [Bitcoin repository](https://github.com/bitcoin/bitcoin)
- [Simple Blockcain in JS](https://github.com/Savjee/SavjeeCoin)
- [Java P2P demonstration](https://www.youtube.com/watch?v=CcLOj3uhb0A)