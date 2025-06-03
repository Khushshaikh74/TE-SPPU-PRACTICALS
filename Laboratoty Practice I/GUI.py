from tkinter import *
from tkinter import ttk

# Create main window
window = Tk()
window.title("Welcome to All")
window.geometry('500x500')
window.configure(background="white")

# Create labels
a = Label(window, text="First Name")
a.grid(row=0, column=0)

b = Label(window, text="Last Name")
b.grid(row=1, column=0)

c = Label(window, text="Email Id")
c.grid(row=2, column=0)

d = Label(window, text="Contact Number")
d.grid(row=3, column=0)

# Create entry fields
a1 = Entry(window)
a1.grid(row=0, column=1)

b1 = Entry(window)
b1.grid(row=1, column=1)

c1 = Entry(window)
c1.grid(row=2, column=1)

d1 = Entry(window)
d1.grid(row=3, column=1)

# Function for button click
def clicked():
    res = "Welcome " + a1.get()  # Use a1 as the variable
    lbl.configure(text=res)  # Configure the label to show the result

# Create a label to display the result
lbl = Label(window, text="")
lbl.grid(row=5, column=0, columnspan=2)

# Create button with function attached
btn = ttk.Button(window, text="Submit", command=clicked)
btn.grid(row=4, column=0, columnspan=2)

# Run the main loop
window.mainloop()
