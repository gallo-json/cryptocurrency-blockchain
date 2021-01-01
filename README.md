# Basic Blockchain Cryptocurrency Implementation in Java

Based on the Bitcoin blockchain.

## Functionality

### Keys

- secp256k1 key cryptography
- SHA256withECDSA transaction signature algorithm

### Comand-line interface to:

- Be either a miner or just a listening node
- Mine the pending transactions into a block
- Make a tranaction
- View blockchain
- View your balance

### Blockchain

- Blocks are stored in an `ArrayList`
- Blocks hashed with SHA256 algorithm

### Peer to peer network

- Only localhost
- Can connect and listen to other peers, assigning you a port
- Miners can broadcast newly mined blocks to other nodes (only full nodes, not other miners, for now)

## How to run

`./gradlew run --console plain`

## Future functionality

- Store transactions in a database rather than an `ArrayList`
- Miners can broadcast to other miners (listening from the receiving miner is what I was having trouble with)