def run_server(host):
    import socket
    addr = socket.getaddrinfo(host, 8000)[0][-1]

    s = socket.socket()
    s.bind(addr)
    s.listen(1)

    print('ouvindo no endereco:', addr)
    while True:
        conn, addr = s.accept()
        request = conn.recv(100)
        response = 'dados recebidos'

        print('recebido:', request)
        conn.send(response)
        conn.close()

