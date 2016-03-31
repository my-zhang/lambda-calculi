(require '[clojure.string :as string])

(defn to-num [s] (Long/parseLong s))

(def n (to-num (read-line)))

(def points (for [_ (range n)] 
              (map to-num (string/split (read-line) #"\s+"))))

(defn distance [a b]
  (let [[xa ya] a
        [xb yb] b]
    (Math/sqrt (+ (Math/pow (- xa xb) 2) (Math/pow (- ya yb) 2)))))

(defn compute-perimeter [points]
  (let [start-points points
        end-points (conj (vec (rest points)) (first points))]
    (apply + (map distance start-points end-points))))

(println (compute-perimeter points))
