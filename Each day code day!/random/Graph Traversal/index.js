/* Graph Representation as Adjacency List
    matrix representation is expensive.

    Imagine we have a dataset that contains airports and routes. 
    We can represent the graph as a Map where each key (node) is an airport and the value (edges) is an array airports that it can connect to.

*/

//Dataset 

const airports = 'PHX BKK OKC JFK LAX MEX EZE HEL LOS LAP LIM'.split(' ');

const routes = [
    ['PHX', 'LAX'],
    ['PHX', 'JFK'],
    ['JFK', 'OKC'],
    ['JFK', 'HEL'],
    ['JFK', 'LOS'],
    ['MEX', 'LAX'],
    ['MEX', 'BKK'],
    ['MEX', 'LIM'],
    ['MEX', 'EZE'],
    ['LIM', 'BKK'],
];

//creating the graph

const adjacencyList = new Map();
//node = key, value (airport, routes[])
function addNode(airport){
    adjacencyList.set(airport,[])
}

//connection between two nodes
function addEdge(origin, destination){
    adjacencyList.get(origin).push(destination)
    adjacencyList.get(destination).push(origin)
}

//create Graph
airports.forEach(addNode); //add every airport as key to the node initialized with empty routes[]
routes.forEach(route => addEdge(...route)) // spread array or use [0][1], [0][2] -> [1][1], [1][2]...

console.log('adjlist', adjacencyList)
//two ways to traverse the graph DFS and BFS

/*Breadth-first Search (BFS) starts by pushing all of the direct children to a queue (first-in, first-out).
  It then visits each item in queue and adds the next layer of children to the back of the queue. 
  This example uses a Set to keep track of nodes that have already been visited. 
*/

// let’s try to determine if a route exists between PHX and BKK.

function bfs(start, end){
    const visited = new Set();
    const queue = [start];


    while(queue.length > 0){

    //get the key (aiport) from the queue    
    const airport = queue.shift();
    console.log('key', airport)
    //get the value (routes[]) from the adjacency List
    const destinations = adjacencyList.get(airport);
    for(const destination of destinations){
        console.log('city', destination)
        if(destination === end){
           
            console.log(`BFS :Yay! a route do exists between ${start} and ${end}` );
            return;
        }

        if(!visited.has(destination)){
            //check if the destination exists if not than add it to set and at the end of the queue
            visited.add(destination);
            queue.push(destination);
            console.log( visited)
            console.log('queue', queue)
        }
    }
    }
    
}

//bfs('PHX','BKK')

/* 
DFS : will go as far into the graph as possible until it reaches a node without any children, 
at which point it backtracks and continues the process. 
The algorithm can be implemented with a recursive function that keeps track of previously visited nodes. 
If a node has not been visited, we call the function recursively.
*/


function dfs(start, visited = new Set()){
    console.log(start);

    visited.add(start);

    const destinations = adjacencyList.get(start); //get routes[]
    console.log('ds',destinations)
    for(const destination of destinations){
        console.log(destination);
        if(destination === 'BKK'){
            console.log('DFS: route found between PHX and BKK')
            return;
        }

        if(!visited.has(destination)){
            console.log('',visited);
            dfs(destination,visited);// make a recursive call if destination has not been visited yet
        }
    }
}

dfs('PHX')