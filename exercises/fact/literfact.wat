(module
;; $iterFact computes factorial:
;; int result = 1;
;; while (i > 0) {
;;   result = result * i;
;;   i = i - 1;
;; }
;; Example: https://developer.mozilla.org/en-US/docs/WebAssembly/Reference/Variables/Local_tee
(func $literFact (param i32) (result i64)
       (local i64)
       (local $var i64)
       i64.const 1
       local.set 1
       (block
           local.get 0
           i64.extend_i32_s
           local.tee $var
           i64.eqz
           br_if 0
           (loop
            local.get 1
            local.get $var
            i64.mul
            local.set 1
            local.get $var 
            i64.const -1
            i64.add
            local.tee $var
            i64.eqz
            br_if 1
            br 0))
       local.get 1)

(export "literFact" (func $literFact))
)
