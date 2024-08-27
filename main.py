import PySimpleGUI as sg
import random

# Function to update the greenhouse status
def update_greenhouse(temperature, humidity, growth):
    return f"Temperature: {temperature}°C\nHumidity: {humidity}%  \nGrowth: {growth}"

# Define the layout
layout = [
    [sg.Text("Greenhouse Climate Control", font=("Helvetica", 20))],
    [sg.Text("Temperature (°C):"), sg.Slider(range=(10, 40), orientation='h', size=(20, 15), key="-TEMP-")],
    [sg.Text("Humidity (%):"), sg.Slider(range=(20, 90), orientation='h', size=(20, 15), key="-HUMID-")],
    [sg.Button("Update"), sg.Button("Auto")],
    [sg.Text("Greenhouse Status:", font=("Helvetica", 16))],
    [sg.Multiline(size=(40, 5), key="-STATUS-", disabled=True)],
    [sg.Canvas(size=(300, 200), key="-CANVAS-")]
]

# Create the window
window = sg.Window("Greenhouse Climate Control", layout, finalize=True)

# Get the canvas element for drawing
canvas = window["-CANVAS-"].TKCanvas

# Initialize greenhouse state
temp = 25
humid = 50
growth = 2
auto_mode = False

# Main event loop
while True:
    event, values = window.read(timeout=1000)  # Update every 1000ms (1 second)
    
    if event == sg.WINDOW_CLOSED:
        break
    
    if event == "Update" or auto_mode:
        temp = values["-TEMP-"]
        humid = values["-HUMID-"]
        growth = values["-GROWTH-"]
    
    if event == "Auto":
        auto_mode = not auto_mode
        if auto_mode:
            window["Auto"].update(text="Manual")
        else:
            window["Auto"].update(text="Auto")
    
    if auto_mode:
        # Simulate automatic adjustments
        temp += random.uniform(-0.5, 0.5)
        humid += random.uniform(-1, 1)
        growth += random.uniform(1, 10)
        window["-TEMP-"].update(temp)
        window["-HUMID-"].update(humid)
        window["-GROWTH-"].update(growth)
    
    # Update status
    status = update_greenhouse(round(temp, 1), round(humid, 1), round(growth, 1))
    window["-STATUS-"].update(status)
    
    # Clear canvas and redraw
    canvas.delete("all")
    
    # Draw temperature bar
    temp_height = (temp - 10) / 30 * 180
    canvas.create_rectangle(50, 200 - temp_height, 100, 200, fill="red")
    canvas.create_text(75, 210, text="Temp")
    
    # Draw humidity bar
    humid_height = humid / 100 * 180
    canvas.create_rectangle(150, 200 - humid_height, 200, 200, fill="blue")
    canvas.create_text(175, 210, text="Humidity")

window.close()