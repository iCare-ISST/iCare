#!/bin/sh
# Ensayo de los casos de prueba de la app iCare

case $1 in
    "alta") curl --data "patient=fede_logo@gmail.com&pulsaciones=160" https://icareisst.appspot.com/medirPulsaciones
            echo 'Esperando…'
            sleep 2
            curl --data "patient=fede_logo@gmail.com&pulsaciones=155" https://icareisst.appspot.com/medirPulsaciones
            echo 'Esperando…'
            sleep 2
            curl --data "patient=fede_logo@gmail.com&pulsaciones=145" https://icareisst.appspot.com/medirPulsaciones
            echo 'Enviado';;
    "media");;
    "baja");;
esac