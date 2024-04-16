Frage 1: Man könnte das Interface als abstrakte Klasse implementieren. Durch die Vererbung kann nicht dupliziert werden und nur von der Oberklasse geerbt werden.

Frage 2 : Durch die Objekterzeugung in einer separaten Klasse ist diese dafür verantwortlich Instanzen von Numbertransformer zu erzeugen. Die Klasse liegt im selben Paket wie die Klasse aus der Instanzen erstellt werden sollen.

Frage 3: Der Anwendungsfall liegt der Fabrikmethode nahe. Die Methode wirkt entkoppelnd, d.h. der Client Code muss nicht geändert werden, wenn eine neue konkrete Klasse hinzugefügt wird.