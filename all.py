import random

def generate_knapsack_items(num_items, max_value, max_weight):
    items = []
    for _ in range(num_items):
        value = random.randint(1, max_value)
        weight = random.randint(1, max_weight)
        items.append((value, weight))
    return items

# Example usage:
num_items = 5
max_value = 100
max_weight = 50
capacity = 60

items = generate_knapsack_items(num_items, max_value, max_weight)
print("Generated items (value, weight):", items)

# Now apply your fractional knapsack code
def fractional_knapsack(capacity, items):
    items.sort(key=lambda x: x[0] / x[1], reverse=True)
    total_value = 0
    for value, weight in items:
        if capacity >= weight:
            total_value += value
            capacity -= weight
        else:
            total_value += value * (capacity / weight)
            break
    return total_value

max_value = fractional_knapsack(capacity, items)
print("Maximum value in knapsack:", max_value)


#-------------------
def fractional_knapsack(capacity, items):
    # Sort items by value/weight ratio
    items.sort(key=lambda x: x[0] / x[1], reverse=True)

    total_value = 0

    for value, weight in items:
        if capacity >= weight:
            total_value += value
            capacity -= weight
        else:
            total_value += value * (capacity / weight)
            break

    return total_value

# Each tuple is (value, weight)
items = [
    (60, 10),
    (100, 20),
    (120, 30)
]

capacity = 50
max_value = fractional_knapsack(capacity, items)

print("Maximum value in knapsack:", max_value)
#--------------------------------------------------------
import numpy as np
import matplotlib.pyplot as plt

def square_function(x):
    return x ** 2

x_values = np.arange(-5, 5, 0.1)

y_values = []

for x in x_values:
    y = square_function(x)
    y_values.append(y)

plt.plot(x_values, y_values)

plt.axvline(x=0, color='red', linestyle='--')

plt.show()
#--------------------
def minimax(node, depth, maxp):
    if depth == 0:
        return node

    if maxp:
        best_value = float('-inf')
        for n in node:
            value = minimax(n, depth - 1, False)
            best_value = max(best_value, value)
        return best_value
    else:
        best_value = float('inf')
        for n in node:
            value = minimax(n, depth - 1, True)
            best_value = min(best_value, value)
        return best_value


tree = [[3, 5], [2, 9]]

result = minimax(tree, 2, True)

print(f"Optimal value for Max player: {result}")
#---------------------------------------------------------------
from itertools import permutations

n = int(input("Number of cities: "))
dist = [list(map(int, input().split())) for _ in range(n)]

min_cost = float('inf')
for p in permutations(range(n)):
    cost = sum(dist[p[i]][p[i+1]] for i in range
print("Minimum tour cost:", min_cost)
#--------------------------------------------------
def dfs(graph, node, visited):
    if node not in visited:
        print(node)
        visited.add(node)

        for neighbor in graph[node]:
            dfs(graph, neighbor, visited)

# Example graph
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

visited = set()
print("DFS starting from node A:")
dfs(graph, 'A', visited)
#-----------------------
def dfs(graph, node, visited):
    if node not in visited:
        print(node)
        visited.add(node)

        for neighbor in graph[node]:
            dfs(graph, neighbor, visited)

# Example graph
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

visited = set()
print("DFS starting from node A:")
dfs(graph, 'A', visited)
#----------------------
from collections import deque

def bfs(graph, start):
    visited = set()
    queue = deque()
    queue.append(start)

    while queue:
        current = queue.popleft()

        if current not in visited:
            print(current)
            visited.add(current)

            for neighbor in graph[current]:
                if neighbor not in visited:
                    queue.append(neighbor)

# Example graph
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

# Run BFS from node 'A'
print("BFS starting from node A:")
bfs(graph, 'A')
#----------------------------------
from queue import PriorityQueue
from collections import defaultdict

def best_first_search(edges, heuristics, start, goal):
    # Create an adjacency list representation of the graph
    graph = defaultdict(list)
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)  # Undirected graph, so add both directions

    # Set of visited nodes to avoid revisiting nodes
    visited = set()

    # Priority queue to select the node with the smallest heuristic value
    pq = PriorityQueue()

    # Add the start node to the priority queue with its heuristic value
    pq.put((heuristics[start], start))  # (priority, node)

    # Dictionary to keep track of the parent of each node for path reconstruction
    parent = {start: None}

    while not pq.empty():
        # Get the node with the lowest heuristic value
        _, current = pq.get()

        # If we reached the goal, stop the search
        if current == goal:
            break

        # Mark the current node as visited
        visited.add(current)

        # Visit all neighbors of the current node
        for neighbor in graph[current]:
            if neighbor not in visited:
                # Add neighbor to the queue with its heuristic value
                pq.put((heuristics[neighbor], neighbor))
                visited.add(neighbor)  # Mark as visited
                parent[neighbor] = current  # Set the parent of the neighbor

    # Reconstruct the path from goal to start using the parent dictionary
    path = []
    while goal:
        path.append(goal)
        goal = parent[goal]

    # Reverse the path to get it from start to goal
    path.reverse()

    return path

if __name__ == "__main__":
    # Define the edges of the graph (undirected)
    edges = [
        ['A', 'B'], ['A', 'C'], ['A', 'D'],
        ['B', 'E'], ['B', 'F'], ['C', 'G'],
        ['C', 'H'], ['D', 'I'], ['I', 'J'],
        ['I', 'K'], ['J', 'L'], ['J', 'M'],
        ['J', 'N']
    ]

    # Define the heuristics (estimates of cost to goal 'N')
    heuristics = {
        'A': 15, 'B': 14, 'C': 13, 'D': 12,
        'E': 11, 'F': 10, 'G': 9, 'H': 8,
        'I': 7, 'J': 5, 'K': 6, 'L': 1,
        'M': 2, 'N': 0  # N is the goal node
    }

    # Define start and goal
    start = 'A'
    goal = 'N'

    # Find the path from start to goal
    path = best_first_search(edges, heuristics, start, goal)

    # Print the resulting path
    print("Path from", start, "to", goal, ":", path)
#-----------------------------------------------