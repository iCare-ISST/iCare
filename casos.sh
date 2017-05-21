#!/bin/sh
# Ensayo de los casos de prueba de la app iCare

case $1 in
    "alta") curl --data "patient=fede_logo@gmail.com&pulsaciones=160" https://icareisst.appspot.com/medirPulsaciones
            echo "Esperando…"
            sleep 2
            curl --data "patient=fede_logo@gmail.com&pulsaciones=155" https://icareisst.appspot.com/medirPulsaciones
            echo "Esperando…"
            sleep 2
            curl --data "patient=fede_logo@gmail.com&pulsaciones=150" https://icareisst.appspot.com/medirPulsaciones
            echo "Enviado";;
    "media") curl --data "patient=rosa.garciap@outlook.com&enCasa=true&grifoAbierto=true" https://icareisst.appspot.com/generarEventos
             echo "Enviado";;
    "baja") curl --data "patient=PR@upm.es&enCasa=true&monoxido=130" https://icareisst.appspot.com/medirMonoxido
            echo "Enviado";;
esac