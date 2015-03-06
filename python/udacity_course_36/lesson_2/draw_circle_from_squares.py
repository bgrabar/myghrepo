import turtle

def draw_circle():
    window = turtle.Screen()
    window.bgcolor("red")

    # create shape
    shape = turtle.Turtle()
    shape.color("yellow")

    # draw
    for i in range(0, 30):
        shape.right(12)
        shape.speed(20)
        for i in range(0, 4):
            shape.forward(100)
            shape.right(90)

    window.exitonclick()

draw_circle()

