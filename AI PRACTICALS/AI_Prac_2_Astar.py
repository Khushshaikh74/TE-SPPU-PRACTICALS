import heapq

def aStar(graph, start, goal, heuristic):
    open_list = []
    heapq.heappush(open_list, (0, start))  #inserting node and cost in open list 

    g_node = {node: float('inf') for node in graph}
    g_node[start] = 0

    came_from = {}

    while open_list:
        current = heapq.heappop(open_list)   #gives lowest f(n) node
        current_node = current[1]   # node name 0->cost 1->node

        if current_node == goal:
            path = []
            while current_node in came_from:
                path.append(current_node)
                current_node = came_from[current_node]  #parent
            path.append(start)
            return path[::-1]

        #    b:1 and c:3                 a
        for neighbour, cost in graph[current_node].items():
            tentative_g = g_node[current_node] + cost
            if tentative_g < g_node[neighbour]:
                g_node[neighbour] = tentative_g
                came_from[neighbour] = current_node   # now B is current node
                f_score = tentative_g + heuristic[neighbour]
                heapq.heappush(open_list, (f_score, neighbour))

    return None

# Graph and heuristic
graph = {
    'A': {'B': 1, 'C': 3},
    'B': {'D': 1, 'E': 4},
    'C': {'F': 2},
    'D': {'G': 2},
    'E': {'G': 1},
    'F': {'G': 5},
    'G': {}
}

heuristic = {
    'A': 6,
    'B': 4,
    'C': 4,
    'D': 2,
    'E': 1,
    'F': 3,
    'G': 0
}

start_node = 'A'
goal_node = 'G'
path = aStar(graph, start_node, goal_node, heuristic)

if path:
    print(f"The path from {start_node} to {goal_node} is: {path}")
else:
    print("No path found")
