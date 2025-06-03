colors = ["red", "blue", "green"]
states = ["WA", "SA", "NT", "Q", "NSW", "V"]
neighbours = {
    'WA': ['NT', 'SA'],
    'NT': ['WA', 'SA', 'Q'],
    'SA': ['WA', 'NT', 'Q', 'NSW', 'V'],
    'Q': ['NT', 'SA', 'NSW'],
    'NSW': ['SA', 'V', 'Q'],
    'V': ['NSW', 'Q']
}

colorOfStates = {}

# checks neighbours of present state do not have same color 
def promising(state, color):
    for neighbor in neighbours.get(state, []):
        if colorOfStates.get(neighbor) == color:
            return False
    return True

def backtrack(state_idx):
    if state_idx == len(states):
        return True

    state = states[state_idx]

    for color in colors:
        if promising(state, color):
            colorOfStates[state] = color

            if backtrack(state_idx + 1):
                return True

            # Backtrack
            del colorOfStates[state]

    return False

def main():
    if backtrack(0):
        print("Solution:", colorOfStates)
    else:
        print("No Solution")

main()
