# avrburner

Inteface linux para gravar o AVR:
Grava e lê os arquivos FLASH (.hex) e EEPROM (.eep).
lodacir@gmail.com para dúvidas.

Necessária a instalação do avrdude 6.2 ou superior, JDK8 e javaFX, utilizar os comandos: 

$sudo apt-get update

Instalar a última versão do avrdude:
$sudo apt-get install avrdude

Instalar JDK-8 e JavaFX:
$sudo apt install openjdk-8-jdk openjfx

com o gravador conectado listar as portas USB:

$ls /dev/tty*

Atribuir permissão 777 para a porta USBx onde x é o número da porta:

$ chmod 777 /dev/ttyUSB0

Microcontroladores suportados:

  uc3a0512 = AT32UC3A0512
  c128     = AT90CAN128
  c32      = AT90CAN32
  c64      = AT90CAN64
  pwm2     = AT90PWM2
  pwm216   = AT90PWM216
  pwm2b    = AT90PWM2B
  pwm3     = AT90PWM3
  pwm316   = AT90PWM316
  pwm3b    = AT90PWM3B
  1200     = AT90S1200
  2313     = AT90S2313
  2333     = AT90S2333
  2343     = AT90S2343
  4414     = AT90S4414
  4433     = AT90S4433
  4434     = AT90S4434
  8515     = AT90S8515
  8535     = AT90S8535
  usb1286  = AT90USB1286
  usb1287  = AT90USB1287
  usb162   = AT90USB162
  usb646   = AT90USB646
  usb647   = AT90USB647
  usb82    = AT90USB82
  m103     = ATmega103
  m128     = ATmega128
  m1280    = ATmega1280
  m1281    = ATmega1281
  m1284    = ATmega1284
  m1284p   = ATmega1284P
  m1284rfr2 = ATmega1284RFR2
  m128rfa1 = ATmega128RFA1
  m128rfr2 = ATmega128RFR2
  m16      = ATmega16
  m161     = ATmega161
  m162     = ATmega162
  m163     = ATmega163
  m164p    = ATmega164P
  m168     = ATmega168
  m168p    = ATmega168P
  m169     = ATmega169
  m16u2    = ATmega16U2
  m2560    = ATmega2560
  m2561    = ATmega2561
  m2564rfr2 = ATmega2564RFR2
  m256rfr2 = ATmega256RFR2
  m32      = ATmega32
  m324p    = ATmega324P
  m324pa   = ATmega324PA
  m325     = ATmega325
  m3250    = ATmega3250
  m328     = ATmega328
  m328p    = ATmega328P
  m329     = ATmega329
  m3290    = ATmega3290
  m3290p   = ATmega3290P
  m329p    = ATmega329P
  m32m1    = ATmega32M1
  m32u2    = ATmega32U2
  m32u4    = ATmega32U4
  m406     = ATMEGA406
  m48      = ATmega48
  m48p     = ATmega48P
  m64      = ATmega64
  m640     = ATmega640
  m644     = ATmega644
  m644p    = ATmega644P
  m644rfr2 = ATmega644RFR2
  m645     = ATmega645
  m6450    = ATmega6450
  m649     = ATmega649
  m6490    = ATmega6490
  m64rfr2  = ATmega64RFR2
  m8       = ATmega8
  m8515    = ATmega8515
  m8535    = ATmega8535
  m88      = ATmega88
  m88p     = ATmega88P
  m8u2     = ATmega8U2
  t10      = ATtiny10
  t11      = ATtiny11
  t12      = ATtiny12
  t13      = ATtiny13
  t15      = ATtiny15
  t1634    = ATtiny1634
  t20      = ATtiny20
  t2313    = ATtiny2313
  t24      = ATtiny24
  t25      = ATtiny25
  t26      = ATtiny26
  t261     = ATtiny261
  t4       = ATtiny4
  t40      = ATtiny40
  t4313    = ATtiny4313
  t43u     = ATtiny43u
  t44      = ATtiny44
  t45      = ATtiny45
  t461     = ATtiny461
  t5       = ATtiny5
  t84      = ATtiny84
  t85      = ATtiny85
  t861     = ATtiny861
  t88      = ATtiny88
  t9       = ATtiny9
  x128a1   = ATxmega128A1
  x128a1d  = ATxmega128A1revD
  x128a1u  = ATxmega128A1U
  x128a3   = ATxmega128A3
  x128a3u  = ATxmega128A3U
  x128a4   = ATxmega128A4
  x128a4u  = ATxmega128A4U
  x128b1   = ATxmega128B1
  x128b3   = ATxmega128B3
  x128c3   = ATxmega128C3
  x128d3   = ATxmega128D3
  x128d4   = ATxmega128D4
  x16a4    = ATxmega16A4
  x16a4u   = ATxmega16A4U
  x16c4    = ATxmega16C4
  x16d4    = ATxmega16D4
  x16e5    = ATxmega16E5
  x192a1   = ATxmega192A1
  x192a3   = ATxmega192A3
  x192a3u  = ATxmega192A3U
  x192c3   = ATxmega192C3
  x192d3   = ATxmega192D3
  x256a1   = ATxmega256A1
  x256a3   = ATxmega256A3
  x256a3b  = ATxmega256A3B
  x256a3bu = ATxmega256A3BU
  x256a3u  = ATxmega256A3U
  x256c3   = ATxmega256C3
  x256d3   = ATxmega256D3
  x32a4    = ATxmega32A4
  x32a4u   = ATxmega32A4U
  x32c4    = ATxmega32C4
  x32d4    = ATxmega32D4
  x32e5    = ATxmega32E5
  x384c3   = ATxmega384C3
  x384d3   = ATxmega384D3
  x64a1    = ATxmega64A1
  x64a1u   = ATxmega64A1U
  x64a3    = ATxmega64A3
  x64a3u   = ATxmega64A3U
  x64a4    = ATxmega64A4
  x64a4u   = ATxmega64A4U
  x64b1    = ATxmega64B1
  x64b3    = ATxmega64B3
  x64c3    = ATxmega64C3
  x64d3    = ATxmega64D3
  x64d4    = ATxmega64D4
  x8e5     = ATxmega8E5
  ucr2     = deprecated, use 'uc3a0512'
  
--------------------------------------------------------------------------------------------------------------------  
Gravadores suportados:
   2232HIO          = FT2232H based generic programmer
  4232h            = FT4232H based generic programmer
  89isp            = Atmel at89isp cable
  abcmini          = ABCmini Board, aka Dick Smith HOTCHIP
  alf              = Nightshade ALF-PgmAVR, http://nightshade.homeip.net/
  arduino          = Arduino
  arduino-ft232r   = Arduino: FT232R connected to ISP
  atisp            = AT-ISP V1.1 programming cable for AVR-SDK1 from <http://micro-research.co.th/> 
  atmelice         = Atmel-ICE (ARM/AVR) in JTAG mode
  atmelice_dw      = Atmel-ICE (ARM/AVR) in debugWIRE mode
  atmelice_isp     = Atmel-ICE (ARM/AVR) in ISP mode
  atmelice_pdi     = Atmel-ICE (ARM/AVR) in PDI mode
  avr109           = Atmel AppNote AVR109 Boot Loader
  avr910           = Atmel Low Cost Serial Programmer
  avr911           = Atmel AppNote AVR911 AVROSP
  avrftdi          = FT2232D based generic programmer
  avrisp           = Atmel AVR ISP
  avrisp2          = Atmel AVR ISP mkII
  avrispmkII       = Atmel AVR ISP mkII
  avrispv2         = Atmel AVR ISP V2
  bascom           = Bascom SAMPLE programming cable
  blaster          = Altera ByteBlaster
  bsd              = Brian Dean's Programmer, http://www.bsdhome.com/avrdude/
  buspirate        = The Bus Pirate
  buspirate_bb     = The Bus Pirate (bitbang interface, supports TPI)
  butterfly        = Atmel Butterfly Development Board
  butterfly_mk     = Mikrokopter.de Butterfly
  bwmega           = BitWizard ftdi_atmega builtin programmer
  C232HM           = FT232H based module from FTDI and Glyn.com.au
  c2n232i          = serial port banging, reset=dtr sck=!rts mosi=!txd miso=!cts
  dapa             = Direct AVR Parallel Access cable
  dasa             = serial port banging, reset=rts sck=dtr mosi=txd miso=cts
  dasa3            = serial port banging, reset=!dtr sck=rts mosi=txd miso=cts
  diecimila        = alias for arduino-ft232r
  dragon_dw        = Atmel AVR Dragon in debugWire mode
  dragon_hvsp      = Atmel AVR Dragon in HVSP mode
  dragon_isp       = Atmel AVR Dragon in ISP mode
  dragon_jtag      = Atmel AVR Dragon in JTAG mode
  dragon_pdi       = Atmel AVR Dragon in PDI mode
  dragon_pp        = Atmel AVR Dragon in PP mode
  dt006            = Dontronics DT006
  ere-isp-avr      = ERE ISP-AVR <http://www.ere.co.th/download/sch050713.pdf>
  flip1            = FLIP USB DFU protocol version 1 (doc7618)
  flip2            = FLIP USB DFU protocol version 2 (AVR4023)
  frank-stk200     = Frank STK200
  ft232r           = FT232R Synchronous BitBang
  ft245r           = FT245R Synchronous BitBang
  futurlec         = Futurlec.com programming cable.
  jtag1            = Atmel JTAG ICE (mkI)
  jtag1slow        = Atmel JTAG ICE (mkI)
  jtag2            = Atmel JTAG ICE mkII
  jtag2avr32       = Atmel JTAG ICE mkII im AVR32 mode
  jtag2dw          = Atmel JTAG ICE mkII in debugWire mode
  jtag2fast        = Atmel JTAG ICE mkII
  jtag2isp         = Atmel JTAG ICE mkII in ISP mode
  jtag2pdi         = Atmel JTAG ICE mkII PDI mode
  jtag2slow        = Atmel JTAG ICE mkII
  jtag3            = Atmel AVR JTAGICE3 in JTAG mode
  jtag3dw          = Atmel AVR JTAGICE3 in debugWIRE mode
  jtag3isp         = Atmel AVR JTAGICE3 in ISP mode
  jtag3pdi         = Atmel AVR JTAGICE3 in PDI mode
  jtagkey          = Amontec JTAGKey, JTAGKey-Tiny and JTAGKey2
  jtagmkI          = Atmel JTAG ICE (mkI)
  jtagmkII         = Atmel JTAG ICE mkII
  jtagmkII_avr32   = Atmel JTAG ICE mkII im AVR32 mode
  lm3s811          = Luminary Micro LM3S811 Eval Board (Rev. A)
  mib510           = Crossbow MIB510 programming board
  mkbutterfly      = Mikrokopter.de Butterfly
  nibobee          = NIBObee
  o-link           = O-Link, OpenJTAG from www.100ask.net
  openmoko         = Openmoko debug board (v3)
  pavr             = Jason Kyle's pAVR Serial Programmer
  pickit2          = MicroChip's PICkit2 Programmer
  picoweb          = Picoweb Programming Cable, http://www.picoweb.net/
  pony-stk200      = Pony Prog STK200
  ponyser          = design ponyprog serial, reset=!txd sck=rts mosi=dtr miso=cts
  siprog           = Lancos SI-Prog <http://www.lancos.com/siprogsch.html>
  sp12             = Steve Bolt's Programmer
  stk200           = STK200
  stk500           = Atmel STK500
  stk500hvsp       = Atmel STK500 V2 in high-voltage serial programming mode
  stk500pp         = Atmel STK500 V2 in parallel programming mode
  stk500v1         = Atmel STK500 Version 1.x firmware
  stk500v2         = Atmel STK500 Version 2.x firmware
  stk600           = Atmel STK600
  stk600hvsp       = Atmel STK600 in high-voltage serial programming mode
  stk600pp         = Atmel STK600 in parallel programming mode
  ttl232r          = FTDI TTL232R-5V with ICSP adapter
  tumpa            = TIAO USB Multi-Protocol Adapter
  UM232H           = FT232H based module from FTDI and Glyn.com.au
  uncompatino      = uncompatino with all pairs of pins shorted
  usbasp           = USBasp, http://www.fischl.de/usbasp/
  usbasp-clone     = Any usbasp clone with correct VID/PID
  usbtiny          = USBtiny simple USB programmer, http://www.ladyada.net/make/usbtinyisp/
  wiring           = Wiring
  xil              = Xilinx JTAG cable
  xplainedpro      = Atmel AVR XplainedPro in JTAG mode

  
