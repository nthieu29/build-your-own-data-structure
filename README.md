# build-your-own-data-structure
Building your own data structure.
Inspired by [build-your-own-x](https://github.com/danistefanovic/build-your-own-x) project.
# ![Build your own data structure](images/feynman.png)

## Introduction
This repository is a Maven project and it contains popular and basic data structure implementation and their unit tests:
* Stack
    * Array implementation :white_check_mark:
    * Linked node implementation :white_check_mark:
* Queue
    * Array implementation :white_check_mark:
    * Linked node implementation :white_check_mark:
    * Priority Queue
* Union Find
    * Quick Find :white_check_mark:
    * Quick Union :white_check_mark:
* Symbol Table
    * Binary Search Tree
    * 2-3 Tree (Red-Black Tree)
    * Hash Table
        * Separate Chaining
        * Linear Probing
* Graph
    * Undirected Graph :white_check_mark:
        * DFS :white_check_mark:
        * BFS :white_check_mark:
        * Cycle Detection :white_check_mark:
        * Connected Component :white_check_mark:
    * Directed Graph
        * DFS :white_check_mark:
        * BFS :white_check_mark:
        * Cycle Detection :white_check_mark:
        * Strong Connected Component :white_check_mark:
    * Edge-weighted graph
        * Minimum Spanning Tree
            * Kruskal's Algorithm :white_check_mark:
            * Prim's Algorithm
                * Lazy version
                * Eager version

Note: :white_check_mark: means implementation and its unit test are available in this repository. Other parts are under construction.

## How to use
* Just clone this repository and provide your own data structure implementations to make all tests pass.
* Run test by following command:

        mvn test
    
* When you get stuck, you could refer the provided default implementations. These implementations focus on simplicity and high readability as well as efficient.  
## References
* [Algorithms, 4th Edition](http://amzn.to/13VNJi7) by Robert Sedgewick and Kevin Wayne.
* [algs4](https://github.com/kevin-wayne/algs4) public repo on Github.