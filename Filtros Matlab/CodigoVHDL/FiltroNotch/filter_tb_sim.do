onbreak resume
onerror resume
vsim -novopt work.filter_tb
add wave sim:/filter_tb/u_FiltroNotch60/clk
add wave sim:/filter_tb/u_FiltroNotch60/clk_enable
add wave sim:/filter_tb/u_FiltroNotch60/reset
add wave sim:/filter_tb/u_FiltroNotch60/filter_in
add wave sim:/filter_tb/u_FiltroNotch60/filter_out
add wave sim:/filter_tb/filter_out_ref
run -all
