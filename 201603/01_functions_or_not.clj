(require '[clojure.string :as string])

(defn to-num [s] (Long/parseLong s))

(def T (to-num (read-line)))

(defn is-func [points]
  (apply distinct? (map first (distinct points))))
  
(dotimes [t T]
  (let [n (to-num (read-line))
        points (for [_ (range n)] (map to-num (string/split (read-line) #"\s+")))]
    (if (is-func points)
      (println "YES")
      (println "NO"))))
