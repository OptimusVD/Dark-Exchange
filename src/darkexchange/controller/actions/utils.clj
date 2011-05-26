(ns darkexchange.controller.actions.utils
  (:require [clojure.contrib.logging :as logging]
            [seesaw.core :as seesaw-core]))

(defn find-component [parent-component id]
  (seesaw-core/select parent-component [id]))

(defn attach-listener [parent-component id listener]
  (seesaw-core/listen (find-component parent-component id)
    :action listener))

(defn close-window [e]
  (let [frame (seesaw-core/to-frame e)]
    (.hide frame)
    (.dispose frame)))

(defn attach-window-close-listener [parent-component id]
  (attach-listener parent-component id close-window))

(defn close-window-and-exit [e]
  (close-window e)
  (System/exit 0))

(defn attach-window-close-and-exit-listener [parent-component id]
  (attach-listener parent-component id close-window-and-exit))