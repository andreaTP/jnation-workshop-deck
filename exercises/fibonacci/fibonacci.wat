(module
;; function fibonacci(n) 
;;    if n < 2
;;        return 1
;;    else 
;;        return fibonacci(n-2) + fibonacci(n-1)
;; 0 - 1 - 1 - 2 - 3 - 5 - 8
  (func $fib (export "fib") (param $n i32) (result i32)
    local.get $n
    i32.const 2
    i32.lt_s
    if
      i32.const 1
      return
    end
    local.get $n
    i32.const 2
    i32.sub
    call $fib
    local.get $n
    i32.const 1
    i32.sub
    call $fib
    i32.add
    return
  )
)
