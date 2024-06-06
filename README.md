# MarioGame

MarioGame is a simple 2D platformer game inspired by the classic Super Mario. The game features Mario, bricks, coins, and coin blocks, and it includes a map defined in a JSON file. This project is built using Java.

## Features

- Play as Mario and navigate through the game world.
- Interact with bricks, coins, and coin blocks.
- Customizable map defined in a JSON file.

## Directory Structure

MarioGame/
├── brick.java
├── Coin.java
├── CoinBlocks.java
├── Controller.java
├── Game.java
├── Json.java
├── Mario.java
├── Model.java
├── Sprite.java
├── View.java
├── map.json
├── coin.png
├── coinblock1.png
├── coinblock2.png
├── mario1.png
├── mario2.png
├── mario3.png
├── mario4.png
├── mario5.png
└── nsync.jpg

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

### Running the Game

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/MarioGame.git
   cd MarioGame
Compile the Java files:


javac *.java
Run the game:


java Game
JSON Map Structure
The map.json file defines the game map and contains an array of sprite objects. Each sprite object has the following properties:

type: The type of the sprite (Brick, CoinBlocks, etc.).
x: The x-coordinate of the sprite on the map.
y: The y-coordinate of the sprite on the map.
w: The width of the sprite.
h: The height of the sprite.
Example map.json:
{
  "sprites": [
    {
      "type": "Brick",
      "x": 416,
      "y": 287,
      "w": 104,
      "h": 98
    },
    {
      "type": "Brick",
      "x": 704,
      "y": 310,
      "w": 100,
      "h": 76
    },
    {
      "type": "CoinBlocks",
      "x": 514,
      "y": 100,
      "w": 146,
      "h": 73
    },
    {
      "type": "Brick",
      "x": 1086,
      "y": 371,
      "w": 112,
      "h": 31
    },
    {
      "type": "CoinBlocks",
      "x": 1076,
      "y": 101,
      "w": 88,
      "h": 89
    }
  ]
}
Contributing
If you would like to contribute to this project, please fork the repository and submit a pull request with your changes.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Acknowledgments
Inspired by the classic Super Mario games.
