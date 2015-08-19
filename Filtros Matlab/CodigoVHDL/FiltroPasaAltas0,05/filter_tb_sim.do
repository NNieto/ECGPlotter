onbreak resume
onerror resume
vsim -novopt work.filter_tb
add wave sim:/filter_tb/u_filtro_0_05/clk
add wave sim:/filter_tb/u_filtro_0_05/clk_enable
add wave sim:/filter_tb/u_filtro_0_05/reset
add wave sim:/filter_tb/u_filtro_0_05/filter_in
add wave sim:/filter_tb/u_filtro_0_05/filter_out
add wave sim:/filter_tb/filter_out_ref
run -all
