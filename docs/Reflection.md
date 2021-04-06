# Reflection

I think this is one of my best and more well rounded projects. I learned a lot from all different aspects. It was also a very challenging project, there were some bugs that were really hard to spot. It was recently that I finished the AP Computer Science A course in Java officially, so I couldn't wait to put my recently learned Java OOP skills to use.

[This](old-class-diagram.jpg) is an old class diagram I made of the project while it was a WIP. I will make a more recent more for documentation purposes.

## Problems

### Blockchain was restarting everytime a new block was added

This bug was due to the fact that I was initializing the blockain wrong every time. The result was that every time a block was added, it would erase all the previous blocks and start from genesis.

### Miners broadcasting newly mined blocks to other miners

This is a problem I still could not fix, but its not that big of a deal in my eyes. I am still happy with the project. The problem was that I marshalled the block in JSON to broadcast it, but I was having trouble recieving it as a miner. As a listing node I didn't have any problem.

## Future functionality / Improvements

- Store transactions in a database rather than an `ArrayList`
- Miners can broadcast to other miners (listening from the receiving miner is what I was having trouble with)
- Make some of the code nicer

## What did I learn?

- Cryptographic algorithms
- Understanding of how a crytpocurrency works
- Understanding of how blockchain works
- Understanding of how a P2P network works
- Little bit of socket programming
- Strengthened my Java OOP skills
- Gradle