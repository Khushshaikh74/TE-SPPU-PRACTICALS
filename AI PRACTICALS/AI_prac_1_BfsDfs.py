graph = {
    'p' : ['q', 'r', 's'],
    'q' : ['x', 'y'],
    'r' : ['z'],
    's' : ['k'],
    'x' : [],
    'y' : [],
    'z' : [],
    'k' : [],
}

# BFS
visited = []
queue = []
def bfs(visited, graph, node):
    visited.append(node)
    queue.append(node)
    while queue:
        m = queue.pop(0)
        print(m, end=" ")

        for neighbour in graph[m]:
            if(neighbour not in visited):
                visited.append(neighbour)
                queue.append(neighbour)


# dfs
visit = set()
def dfs(visit, graph, node):
    if node not in visit:
        print(node, end=" ")
        visit.add(node)

        for neighbour in graph[node]:
            dfs(visit, graph, neighbour)


print("BFS Traversal: ")
bfs(visited, graph, 'p')              

print("\n\nDFS Traversal: ")
dfs(visit, graph, 'p')      