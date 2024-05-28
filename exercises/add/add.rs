#[cfg_attr(all(target_arch = "wasm32"), export_name = "add")]
#[no_mangle]
pub unsafe extern fn add(a: i32, b: i32) -> i32 {
  a + b
}
