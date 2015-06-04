import turtle

def draw_square(shape):
    for i in range(0, 4):
        shape.forward(100)
        shape.right(90)

def draw_art():
    window = turtle.Screen()
    window.bgcolor("red")

    # create shape to draw square
    shape_a = turtle.Turtle()
    shape_a.shape("triangle")
    shape_a.color("blue")
    shape_a.speed(2)
    draw_square(shape_a)

    # create shape to draw circle
    shape_b = turtle.Turtle()
    shape_b.shape("turtle")
    shape_b.color("yellow")
    shape_b.circle(100)

    # create shape to draw triangle
    shape_c = turtle.Turtle()
    shape_c.shape("classic")
    shape_c.color("green")
    shape_c.speed(2)

    shape_c.right(113)

    for i in range(0, 3):
        shape_c.forward(100)
        shape_c.right(120)

    window.exitonclick()


draw_art()

