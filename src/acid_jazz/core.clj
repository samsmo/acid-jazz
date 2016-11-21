(ns acid-jazz.core
  (:use [overtone.live]
        [overtone.inst.drum]))

(def metro (metronome 90))

(defn player [beat]
  (at (metro (+ 0.75 beat)) (kick))
  (at (metro (+ 0.25 beat)) (kick))
  (at (metro (+ 0.25 beat)) (closed-hat))
  (apply-by (metro (inc beat)) #'player (inc beat) []))

(player (metro))

(stop)
