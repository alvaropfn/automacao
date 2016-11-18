#include <ESP8266WiFi.h>
#include <aREST.h>
#include <dht11.h>

// criação do objeto sensor DHT atrelado ao pino
const int dht_pin = 4;
dht11 dht_sensor;
float temperature;
float humidity;

// cria uma instancia aREST
aREST rest = aREST();

// rede e senha a se conectar
const char* ssid = "nmdn";
const char* pass = "nmdn.691";

// cria uma instancia do servidor ouvindo nessa porta
WiFiServer server(80);

double celcius(double temp)
{return((double)(9/5) * temp) + 32;}

const int ledPin = 2;

int ledControl(String command)
{
  int state =  command.toInt();
  digitalWrite(ledPin, state);
  
  return state;
}

void setup()
{
  pinMode(ledPin, OUTPUT);
  
  // inicialização da comunicação serial para debug
  Serial.begin(115200);
  delay(10);
  Serial.println();

  // expondo variaveis a leituras restful
  rest.variable("temperature", &temperature);
  rest.variable("humidity", &humidity);
  
  // expondo a função pra interação restful
  rest.function("led",ledControl);

  // Give name & ID to the device (ID should be 6 characters long)
  rest.set_id("1");
  rest.set_name("ESP_TESTE");

  //conectando a WiFi
  WiFi.begin(ssid, pass);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi conetado");

  // inicializando o servidor
  server.begin();
  Serial.println("Servidor inicializado");
  Serial.println(WiFi.localIP());
}


void loop()
{
  WiFiClient client = server.available();

  if (!client) return;
  /*
  temperature = 30;
  humidity = 80;
  */
  // checagem da leitura de dados
  int chk = dht_sensor.read(dht_pin);
  
  switch (chk) {
    case DHTLIB_OK:
      humidity = dht_sensor.humidity;
      temperature = dht_sensor.temperature;
      break;
    case DHTLIB_ERROR_CHECKSUM:
      Serial.print("checksun error, \t");
      break;
    case DHTLIB_ERROR_TIMEOUT:
      Serial.print("timeout error, \t");
      break;
  }
  
  

  while (!client.available()) delay(1);

  rest.handle(client);
}

