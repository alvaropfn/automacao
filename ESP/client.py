import socket

host = '192.168.0.108'
port = 8000

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect((host, port))

message = 'msg client to server'
sock.send(message)
response = sock.recv(100)
print(response)
sock.close()

