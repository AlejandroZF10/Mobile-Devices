void setup()
{
  pinMode(13,OUTPUT);//Seleccionamos el pin 13 como salida
  Serial.begin(9600);//Inicializamos el valor de transmisión.
}

void loop()
{
  while (Serial.available())//Declaramos un sentencia, Mientras el puerto Serial este disponible se empieza el ciclo 
  {
    char dato= Serial.read(); //Declaramos una variable de tipo carácter y Seo lee la variale enviada desde el Bluetooth.
    digitalWrite(13,LOW); //Indicamos que en el puerto 13 la señal será baja por lo que el LED estará apagado.
    switch(dato)
    {
    case 'A': //Si en el caso de ser A la varible enviada, entonces:
      {
        digitalWrite(13,HIGH);//La señal será alta, encenderá el LED.
        Serial.println("Led encendido");//Se mostrará un mensaje.
        break;//El caso se detiene.
      }
    case 'B': //Si en el caso de ser A la variable enviada, entonceS:
      {
        digitalWrite(13,LOW);//la señal será baja por lo que el LED estará apagado.
        Serial.println("Led apagado");//Se mostrará un mensaje.
        break;
      }
    }       
  }
  Serial.flush();
}
