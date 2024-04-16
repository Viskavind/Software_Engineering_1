Frage 1: Man könnte das Interface als abstrakte Klasse implementieren. Durch die Vererbung kann nicht dupliziert werden und nur von der Oberklasse geerbt werden.

Frage 2 : Durch die Objekterzeugung in einer separaten Klasse ist diese dafür verantwortlich Instanzen von Numbertransformer zu erzeugen. Die Klasse liegt im selben Paket wie die Klasse aus der Instanzen erstellt werden sollen.

Frage 3: Der Anwendungsfall liegt der Fabrikmethode nahe. Die Methode wirkt entkoppelnd, d.h. der Client Code muss nicht geändert werden, wenn eine neue konkrete Klasse hinzugefügt wird.

Frage 4: Sie sollten in einer Test-Klasse implementiert werden damit man sie von Produktions-Code unterschieden werden können und diesen nicht unübersichtlich machen. Außerdem ist der Test-Code dann unabhängig.

Frage 5: Äquivalenzklassen dienen dazu Test-Optionen zu Gruppieren für die, die selbe Ergebnisart erwartet wird. Da aus Zeit und Kostengründen nicht jeder einzelne Test abgedeckt werden kann.

Frage 6: Es lässt sich kein Blackbox-Test umsetzen, da die Klasse einen void zurück gibt, damit kommt nichts aus der Blackbox raus, dass man testen könnte.
