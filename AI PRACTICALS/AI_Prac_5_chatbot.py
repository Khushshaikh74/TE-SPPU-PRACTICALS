from tkinter import *

chat = Tk()
chat.title("CHATBOT")

def send():
    msg = "You: " + e.get()
    txt.insert(END, msg + "\n")  # Add newline for formatting
    user = e.get().lower()
    e.delete(0, END)  # Clear the input after sending

    if user == "hello":
        txt.insert(END, "Bot: hi\n")
    elif user in ["hi", "hii", "hiii"]:
        txt.insert(END, "Bot: hello, good to see you\n")
    elif user == "how are you":
        txt.insert(END, "Bot: I am fine and you?\n")
    elif user in ["i am good", "i am doing well", "fine"]:
        txt.insert(END, "Bot: Great! How can I help you today?\n")
    else:
        txt.insert(END, "Bot: Sorry! I did not understand\n")

txt = Text(chat)
txt.grid(row=0, column=0, columnspan=2)

e = Entry(chat, width=100)
e.grid(row=1, column=0)

send_btn = Button(chat, text="Send", command=send)
send_btn.grid(row=1, column=1)

chat.mainloop()
