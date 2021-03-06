-- -------------------------------------------------------------
--
-- Module: filtro_0_05
-- Generated by MATLAB(R) 8.5 and the Filter Design HDL Coder 2.9.7.
-- Generated on: 2015-08-18 21:11:34
-- -------------------------------------------------------------

-- -------------------------------------------------------------
-- HDL Code Generation Options:
--
-- TargetLanguage: VHDL
-- TargetDirectory: C:\Users\Alejandro\Documents\GitHub\Dev-Java\ECGPlotter\Filtros Matlab\CodigoVHDL\FiltroPasaAltas0,05
-- Name: filtro_0,05
-- TestBenchStimulus: impulse step ramp chirp noise 

-- -------------------------------------------------------------
-- HDL Implementation    : Fully parallel
-- Multipliers           : 101
-- Folding Factor        : 1
-- -------------------------------------------------------------
-- Filter Settings:
--
-- Discrete-Time FIR Filter (real)
-- -------------------------------
-- Filter Structure  : Direct-Form FIR
-- Filter Length     : 101
-- Stable            : Yes
-- Linear Phase      : Yes (Type 1)
-- -------------------------------------------------------------
LIBRARY IEEE;
USE IEEE.std_logic_1164.all;
USE IEEE.numeric_std.ALL;

ENTITY filtro_0_05 IS
   PORT( clk                             :   IN    std_logic; 
         clk_enable                      :   IN    std_logic; 
         reset                           :   IN    std_logic; 
         filter_in                       :   IN    real; -- double
         filter_out                      :   OUT   real  -- double
         );

END filtro_0_05;


----------------------------------------------------------------
--Module Architecture: filtro_0_05
----------------------------------------------------------------
ARCHITECTURE rtl OF filtro_0_05 IS
  -- Local Functions
  -- Type Definitions
  TYPE delay_pipeline_type IS ARRAY (NATURAL range <>) OF real; -- double
  -- Constants
  CONSTANT coeff1                         : real := -5.1282068914773331E-07; -- double
  CONSTANT coeff2                         : real := -5.1863931591196077E-07; -- double
  CONSTANT coeff3                         : real := -5.3607222601324345E-07; -- double
  CONSTANT coeff4                         : real := -5.6505061992153364E-07; -- double
  CONSTANT coeff5                         : real := -6.0546013339664920E-07; -- double
  CONSTANT coeff6                         : real := -6.5714128874161788E-07; -- double
  CONSTANT coeff7                         : real := -7.1989012428986722E-07; -- double
  CONSTANT coeff8                         : real := -7.9345899917477607E-07; -- double
  CONSTANT coeff9                         : real := -8.7755757090498091E-07; -- double
  CONSTANT coeff10                        : real := -9.7185394094987075E-07; -- double
  CONSTANT coeff11                        : real := -1.0759759648313944E-06; -- double
  CONSTANT coeff12                        : real := -1.1895127205426076E-06; -- double
  CONSTANT coeff13                        : real := -1.3120161305998573E-06; -- double
  CONSTANT coeff14                        : real := -1.4430027300158032E-06; -- double
  CONSTANT coeff15                        : real := -1.5819555747125405E-06; -- double
  CONSTANT coeff16                        : real := -1.7283262813067233E-06; -- double
  CONSTANT coeff17                        : real := -1.8815371916447657E-06; -- double
  CONSTANT coeff18                        : real := -2.0409836522771217E-06; -- double
  CONSTANT coeff19                        : real := -2.2060364009316656E-06; -- double
  CONSTANT coeff20                        : real := -2.3760440497898805E-06; -- double
  CONSTANT coeff21                        : real := -2.5503356565304892E-06; -- double
  CONSTANT coeff22                        : real := -2.7282233715926289E-06; -- double
  CONSTANT coeff23                        : real := -2.9090051536244056E-06; -- double
  CONSTANT coeff24                        : real := -3.0919675393849518E-06; -- double
  CONSTANT coeff25                        : real := -3.2763884600607629E-06; -- double
  CONSTANT coeff26                        : real := -3.4615400904562680E-06; -- double
  CONSTANT coeff27                        : real := -3.6466917216261955E-06; -- double
  CONSTANT coeff28                        : real := -3.8311126445534219E-06; -- double
  CONSTANT coeff29                        : real := -4.0140750343804975E-06; -- double
  CONSTANT coeff30                        : real := -4.1948568216624215E-06; -- double
  CONSTANT coeff31                        : real := -4.3727445435440060E-06; -- double
  CONSTANT coeff32                        : real := -4.5470361581948048E-06; -- double
  CONSTANT coeff33                        : real := -4.7170438164906578E-06; -- double
  CONSTANT coeff34                        : real := -4.8820965755146964E-06; -- double
  CONSTANT coeff35                        : real := -5.0415430474965958E-06; -- double
  CONSTANT coeff36                        : real := -5.1947539698447028E-06; -- double
  CONSTANT coeff37                        : real := -5.3411246893641451E-06; -- double
  CONSTANT coeff38                        : real := -5.4800775472703274E-06; -- double
  CONSTANT coeff39                        : real := -5.6110641601563487E-06; -- double
  CONSTANT coeff40                        : real := -5.7335675835069097E-06; -- double
  CONSTANT coeff41                        : real := -5.8471043526977324E-06; -- double
  CONSTANT coeff42                        : real := -5.9512263893613491E-06; -- double
  CONSTANT coeff43                        : real := -6.0455227717170893E-06; -- double
  CONSTANT coeff44                        : real := -6.1296213546868039E-06; -- double
  CONSTANT coeff45                        : real := -6.2031902398390107E-06; -- double
  CONSTANT coeff46                        : real := -6.2659390840583228E-06; -- double
  CONSTANT coeff47                        : real := -6.3176202465951680E-06; -- double
  CONSTANT coeff48                        : real := -6.3580297651800278E-06; -- double
  CONSTANT coeff49                        : real := -6.3870081621916443E-06; -- double
  CONSTANT coeff50                        : real := -6.4044410728115261E-06; -- double
  CONSTANT coeff51                        : real := 9.9999410256099230E-01; -- double
  CONSTANT coeff52                        : real := -6.4044410728115261E-06; -- double
  CONSTANT coeff53                        : real := -6.3870081621916443E-06; -- double
  CONSTANT coeff54                        : real := -6.3580297651800278E-06; -- double
  CONSTANT coeff55                        : real := -6.3176202465951680E-06; -- double
  CONSTANT coeff56                        : real := -6.2659390840583228E-06; -- double
  CONSTANT coeff57                        : real := -6.2031902398390107E-06; -- double
  CONSTANT coeff58                        : real := -6.1296213546868039E-06; -- double
  CONSTANT coeff59                        : real := -6.0455227717170893E-06; -- double
  CONSTANT coeff60                        : real := -5.9512263893613491E-06; -- double
  CONSTANT coeff61                        : real := -5.8471043526977324E-06; -- double
  CONSTANT coeff62                        : real := -5.7335675835069097E-06; -- double
  CONSTANT coeff63                        : real := -5.6110641601563487E-06; -- double
  CONSTANT coeff64                        : real := -5.4800775472703274E-06; -- double
  CONSTANT coeff65                        : real := -5.3411246893641451E-06; -- double
  CONSTANT coeff66                        : real := -5.1947539698447028E-06; -- double
  CONSTANT coeff67                        : real := -5.0415430474965958E-06; -- double
  CONSTANT coeff68                        : real := -4.8820965755146964E-06; -- double
  CONSTANT coeff69                        : real := -4.7170438164906578E-06; -- double
  CONSTANT coeff70                        : real := -4.5470361581948048E-06; -- double
  CONSTANT coeff71                        : real := -4.3727445435440060E-06; -- double
  CONSTANT coeff72                        : real := -4.1948568216624215E-06; -- double
  CONSTANT coeff73                        : real := -4.0140750343804975E-06; -- double
  CONSTANT coeff74                        : real := -3.8311126445534219E-06; -- double
  CONSTANT coeff75                        : real := -3.6466917216261955E-06; -- double
  CONSTANT coeff76                        : real := -3.4615400904562680E-06; -- double
  CONSTANT coeff77                        : real := -3.2763884600607629E-06; -- double
  CONSTANT coeff78                        : real := -3.0919675393849518E-06; -- double
  CONSTANT coeff79                        : real := -2.9090051536244056E-06; -- double
  CONSTANT coeff80                        : real := -2.7282233715926289E-06; -- double
  CONSTANT coeff81                        : real := -2.5503356565304892E-06; -- double
  CONSTANT coeff82                        : real := -2.3760440497898805E-06; -- double
  CONSTANT coeff83                        : real := -2.2060364009316656E-06; -- double
  CONSTANT coeff84                        : real := -2.0409836522771217E-06; -- double
  CONSTANT coeff85                        : real := -1.8815371916447657E-06; -- double
  CONSTANT coeff86                        : real := -1.7283262813067233E-06; -- double
  CONSTANT coeff87                        : real := -1.5819555747125405E-06; -- double
  CONSTANT coeff88                        : real := -1.4430027300158032E-06; -- double
  CONSTANT coeff89                        : real := -1.3120161305998573E-06; -- double
  CONSTANT coeff90                        : real := -1.1895127205426076E-06; -- double
  CONSTANT coeff91                        : real := -1.0759759648313944E-06; -- double
  CONSTANT coeff92                        : real := -9.7185394094987075E-07; -- double
  CONSTANT coeff93                        : real := -8.7755757090498091E-07; -- double
  CONSTANT coeff94                        : real := -7.9345899917477607E-07; -- double
  CONSTANT coeff95                        : real := -7.1989012428986722E-07; -- double
  CONSTANT coeff96                        : real := -6.5714128874161788E-07; -- double
  CONSTANT coeff97                        : real := -6.0546013339664920E-07; -- double
  CONSTANT coeff98                        : real := -5.6505061992153364E-07; -- double
  CONSTANT coeff99                        : real := -5.3607222601324345E-07; -- double
  CONSTANT coeff100                       : real := -5.1863931591196077E-07; -- double
  CONSTANT coeff101                       : real := -5.1282068914773331E-07; -- double

  -- Signals
  SIGNAL delay_pipeline                   : delay_pipeline_type(0 TO 100) := (0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0.0); -- double
  SIGNAL product101                       : real := 0.0; -- double
  SIGNAL product100                       : real := 0.0; -- double
  SIGNAL product99                        : real := 0.0; -- double
  SIGNAL product98                        : real := 0.0; -- double
  SIGNAL product97                        : real := 0.0; -- double
  SIGNAL product96                        : real := 0.0; -- double
  SIGNAL product95                        : real := 0.0; -- double
  SIGNAL product94                        : real := 0.0; -- double
  SIGNAL product93                        : real := 0.0; -- double
  SIGNAL product92                        : real := 0.0; -- double
  SIGNAL product91                        : real := 0.0; -- double
  SIGNAL product90                        : real := 0.0; -- double
  SIGNAL product89                        : real := 0.0; -- double
  SIGNAL product88                        : real := 0.0; -- double
  SIGNAL product87                        : real := 0.0; -- double
  SIGNAL product86                        : real := 0.0; -- double
  SIGNAL product85                        : real := 0.0; -- double
  SIGNAL product84                        : real := 0.0; -- double
  SIGNAL product83                        : real := 0.0; -- double
  SIGNAL product82                        : real := 0.0; -- double
  SIGNAL product81                        : real := 0.0; -- double
  SIGNAL product80                        : real := 0.0; -- double
  SIGNAL product79                        : real := 0.0; -- double
  SIGNAL product78                        : real := 0.0; -- double
  SIGNAL product77                        : real := 0.0; -- double
  SIGNAL product76                        : real := 0.0; -- double
  SIGNAL product75                        : real := 0.0; -- double
  SIGNAL product74                        : real := 0.0; -- double
  SIGNAL product73                        : real := 0.0; -- double
  SIGNAL product72                        : real := 0.0; -- double
  SIGNAL product71                        : real := 0.0; -- double
  SIGNAL product70                        : real := 0.0; -- double
  SIGNAL product69                        : real := 0.0; -- double
  SIGNAL product68                        : real := 0.0; -- double
  SIGNAL product67                        : real := 0.0; -- double
  SIGNAL product66                        : real := 0.0; -- double
  SIGNAL product65                        : real := 0.0; -- double
  SIGNAL product64                        : real := 0.0; -- double
  SIGNAL product63                        : real := 0.0; -- double
  SIGNAL product62                        : real := 0.0; -- double
  SIGNAL product61                        : real := 0.0; -- double
  SIGNAL product60                        : real := 0.0; -- double
  SIGNAL product59                        : real := 0.0; -- double
  SIGNAL product58                        : real := 0.0; -- double
  SIGNAL product57                        : real := 0.0; -- double
  SIGNAL product56                        : real := 0.0; -- double
  SIGNAL product55                        : real := 0.0; -- double
  SIGNAL product54                        : real := 0.0; -- double
  SIGNAL product53                        : real := 0.0; -- double
  SIGNAL product52                        : real := 0.0; -- double
  SIGNAL product51                        : real := 0.0; -- double
  SIGNAL product50                        : real := 0.0; -- double
  SIGNAL product49                        : real := 0.0; -- double
  SIGNAL product48                        : real := 0.0; -- double
  SIGNAL product47                        : real := 0.0; -- double
  SIGNAL product46                        : real := 0.0; -- double
  SIGNAL product45                        : real := 0.0; -- double
  SIGNAL product44                        : real := 0.0; -- double
  SIGNAL product43                        : real := 0.0; -- double
  SIGNAL product42                        : real := 0.0; -- double
  SIGNAL product41                        : real := 0.0; -- double
  SIGNAL product40                        : real := 0.0; -- double
  SIGNAL product39                        : real := 0.0; -- double
  SIGNAL product38                        : real := 0.0; -- double
  SIGNAL product37                        : real := 0.0; -- double
  SIGNAL product36                        : real := 0.0; -- double
  SIGNAL product35                        : real := 0.0; -- double
  SIGNAL product34                        : real := 0.0; -- double
  SIGNAL product33                        : real := 0.0; -- double
  SIGNAL product32                        : real := 0.0; -- double
  SIGNAL product31                        : real := 0.0; -- double
  SIGNAL product30                        : real := 0.0; -- double
  SIGNAL product29                        : real := 0.0; -- double
  SIGNAL product28                        : real := 0.0; -- double
  SIGNAL product27                        : real := 0.0; -- double
  SIGNAL product26                        : real := 0.0; -- double
  SIGNAL product25                        : real := 0.0; -- double
  SIGNAL product24                        : real := 0.0; -- double
  SIGNAL product23                        : real := 0.0; -- double
  SIGNAL product22                        : real := 0.0; -- double
  SIGNAL product21                        : real := 0.0; -- double
  SIGNAL product20                        : real := 0.0; -- double
  SIGNAL product19                        : real := 0.0; -- double
  SIGNAL product18                        : real := 0.0; -- double
  SIGNAL product17                        : real := 0.0; -- double
  SIGNAL product16                        : real := 0.0; -- double
  SIGNAL product15                        : real := 0.0; -- double
  SIGNAL product14                        : real := 0.0; -- double
  SIGNAL product13                        : real := 0.0; -- double
  SIGNAL product12                        : real := 0.0; -- double
  SIGNAL product11                        : real := 0.0; -- double
  SIGNAL product10                        : real := 0.0; -- double
  SIGNAL product9                         : real := 0.0; -- double
  SIGNAL product8                         : real := 0.0; -- double
  SIGNAL product7                         : real := 0.0; -- double
  SIGNAL product6                         : real := 0.0; -- double
  SIGNAL product5                         : real := 0.0; -- double
  SIGNAL product4                         : real := 0.0; -- double
  SIGNAL product3                         : real := 0.0; -- double
  SIGNAL product2                         : real := 0.0; -- double
  SIGNAL product1_cast                    : real := 0.0; -- double
  SIGNAL product1                         : real := 0.0; -- double
  SIGNAL sum1                             : real := 0.0; -- double
  SIGNAL sum2                             : real := 0.0; -- double
  SIGNAL sum3                             : real := 0.0; -- double
  SIGNAL sum4                             : real := 0.0; -- double
  SIGNAL sum5                             : real := 0.0; -- double
  SIGNAL sum6                             : real := 0.0; -- double
  SIGNAL sum7                             : real := 0.0; -- double
  SIGNAL sum8                             : real := 0.0; -- double
  SIGNAL sum9                             : real := 0.0; -- double
  SIGNAL sum10                            : real := 0.0; -- double
  SIGNAL sum11                            : real := 0.0; -- double
  SIGNAL sum12                            : real := 0.0; -- double
  SIGNAL sum13                            : real := 0.0; -- double
  SIGNAL sum14                            : real := 0.0; -- double
  SIGNAL sum15                            : real := 0.0; -- double
  SIGNAL sum16                            : real := 0.0; -- double
  SIGNAL sum17                            : real := 0.0; -- double
  SIGNAL sum18                            : real := 0.0; -- double
  SIGNAL sum19                            : real := 0.0; -- double
  SIGNAL sum20                            : real := 0.0; -- double
  SIGNAL sum21                            : real := 0.0; -- double
  SIGNAL sum22                            : real := 0.0; -- double
  SIGNAL sum23                            : real := 0.0; -- double
  SIGNAL sum24                            : real := 0.0; -- double
  SIGNAL sum25                            : real := 0.0; -- double
  SIGNAL sum26                            : real := 0.0; -- double
  SIGNAL sum27                            : real := 0.0; -- double
  SIGNAL sum28                            : real := 0.0; -- double
  SIGNAL sum29                            : real := 0.0; -- double
  SIGNAL sum30                            : real := 0.0; -- double
  SIGNAL sum31                            : real := 0.0; -- double
  SIGNAL sum32                            : real := 0.0; -- double
  SIGNAL sum33                            : real := 0.0; -- double
  SIGNAL sum34                            : real := 0.0; -- double
  SIGNAL sum35                            : real := 0.0; -- double
  SIGNAL sum36                            : real := 0.0; -- double
  SIGNAL sum37                            : real := 0.0; -- double
  SIGNAL sum38                            : real := 0.0; -- double
  SIGNAL sum39                            : real := 0.0; -- double
  SIGNAL sum40                            : real := 0.0; -- double
  SIGNAL sum41                            : real := 0.0; -- double
  SIGNAL sum42                            : real := 0.0; -- double
  SIGNAL sum43                            : real := 0.0; -- double
  SIGNAL sum44                            : real := 0.0; -- double
  SIGNAL sum45                            : real := 0.0; -- double
  SIGNAL sum46                            : real := 0.0; -- double
  SIGNAL sum47                            : real := 0.0; -- double
  SIGNAL sum48                            : real := 0.0; -- double
  SIGNAL sum49                            : real := 0.0; -- double
  SIGNAL sum50                            : real := 0.0; -- double
  SIGNAL sum51                            : real := 0.0; -- double
  SIGNAL sum52                            : real := 0.0; -- double
  SIGNAL sum53                            : real := 0.0; -- double
  SIGNAL sum54                            : real := 0.0; -- double
  SIGNAL sum55                            : real := 0.0; -- double
  SIGNAL sum56                            : real := 0.0; -- double
  SIGNAL sum57                            : real := 0.0; -- double
  SIGNAL sum58                            : real := 0.0; -- double
  SIGNAL sum59                            : real := 0.0; -- double
  SIGNAL sum60                            : real := 0.0; -- double
  SIGNAL sum61                            : real := 0.0; -- double
  SIGNAL sum62                            : real := 0.0; -- double
  SIGNAL sum63                            : real := 0.0; -- double
  SIGNAL sum64                            : real := 0.0; -- double
  SIGNAL sum65                            : real := 0.0; -- double
  SIGNAL sum66                            : real := 0.0; -- double
  SIGNAL sum67                            : real := 0.0; -- double
  SIGNAL sum68                            : real := 0.0; -- double
  SIGNAL sum69                            : real := 0.0; -- double
  SIGNAL sum70                            : real := 0.0; -- double
  SIGNAL sum71                            : real := 0.0; -- double
  SIGNAL sum72                            : real := 0.0; -- double
  SIGNAL sum73                            : real := 0.0; -- double
  SIGNAL sum74                            : real := 0.0; -- double
  SIGNAL sum75                            : real := 0.0; -- double
  SIGNAL sum76                            : real := 0.0; -- double
  SIGNAL sum77                            : real := 0.0; -- double
  SIGNAL sum78                            : real := 0.0; -- double
  SIGNAL sum79                            : real := 0.0; -- double
  SIGNAL sum80                            : real := 0.0; -- double
  SIGNAL sum81                            : real := 0.0; -- double
  SIGNAL sum82                            : real := 0.0; -- double
  SIGNAL sum83                            : real := 0.0; -- double
  SIGNAL sum84                            : real := 0.0; -- double
  SIGNAL sum85                            : real := 0.0; -- double
  SIGNAL sum86                            : real := 0.0; -- double
  SIGNAL sum87                            : real := 0.0; -- double
  SIGNAL sum88                            : real := 0.0; -- double
  SIGNAL sum89                            : real := 0.0; -- double
  SIGNAL sum90                            : real := 0.0; -- double
  SIGNAL sum91                            : real := 0.0; -- double
  SIGNAL sum92                            : real := 0.0; -- double
  SIGNAL sum93                            : real := 0.0; -- double
  SIGNAL sum94                            : real := 0.0; -- double
  SIGNAL sum95                            : real := 0.0; -- double
  SIGNAL sum96                            : real := 0.0; -- double
  SIGNAL sum97                            : real := 0.0; -- double
  SIGNAL sum98                            : real := 0.0; -- double
  SIGNAL sum99                            : real := 0.0; -- double
  SIGNAL sum100                           : real := 0.0; -- double
  SIGNAL output_register                  : real := 0.0; -- double


BEGIN

  -- Block Statements
  Delay_Pipeline_process : PROCESS (clk, reset)
  BEGIN
    IF reset = '1' THEN
      delay_pipeline(0 TO 100) <= (OTHERS => 0.0000000000000000E+00);
    ELSIF clk'event AND clk = '1' THEN
      IF clk_enable = '1' THEN
        delay_pipeline(0) <= filter_in;
        delay_pipeline(1 TO 100) <= delay_pipeline(0 TO 99);
      END IF;
    END IF; 
  END PROCESS Delay_Pipeline_process;

  product101 <= delay_pipeline(100) * coeff101;

  product100 <= delay_pipeline(99) * coeff100;

  product99 <= delay_pipeline(98) * coeff99;

  product98 <= delay_pipeline(97) * coeff98;

  product97 <= delay_pipeline(96) * coeff97;

  product96 <= delay_pipeline(95) * coeff96;

  product95 <= delay_pipeline(94) * coeff95;

  product94 <= delay_pipeline(93) * coeff94;

  product93 <= delay_pipeline(92) * coeff93;

  product92 <= delay_pipeline(91) * coeff92;

  product91 <= delay_pipeline(90) * coeff91;

  product90 <= delay_pipeline(89) * coeff90;

  product89 <= delay_pipeline(88) * coeff89;

  product88 <= delay_pipeline(87) * coeff88;

  product87 <= delay_pipeline(86) * coeff87;

  product86 <= delay_pipeline(85) * coeff86;

  product85 <= delay_pipeline(84) * coeff85;

  product84 <= delay_pipeline(83) * coeff84;

  product83 <= delay_pipeline(82) * coeff83;

  product82 <= delay_pipeline(81) * coeff82;

  product81 <= delay_pipeline(80) * coeff81;

  product80 <= delay_pipeline(79) * coeff80;

  product79 <= delay_pipeline(78) * coeff79;

  product78 <= delay_pipeline(77) * coeff78;

  product77 <= delay_pipeline(76) * coeff77;

  product76 <= delay_pipeline(75) * coeff76;

  product75 <= delay_pipeline(74) * coeff75;

  product74 <= delay_pipeline(73) * coeff74;

  product73 <= delay_pipeline(72) * coeff73;

  product72 <= delay_pipeline(71) * coeff72;

  product71 <= delay_pipeline(70) * coeff71;

  product70 <= delay_pipeline(69) * coeff70;

  product69 <= delay_pipeline(68) * coeff69;

  product68 <= delay_pipeline(67) * coeff68;

  product67 <= delay_pipeline(66) * coeff67;

  product66 <= delay_pipeline(65) * coeff66;

  product65 <= delay_pipeline(64) * coeff65;

  product64 <= delay_pipeline(63) * coeff64;

  product63 <= delay_pipeline(62) * coeff63;

  product62 <= delay_pipeline(61) * coeff62;

  product61 <= delay_pipeline(60) * coeff61;

  product60 <= delay_pipeline(59) * coeff60;

  product59 <= delay_pipeline(58) * coeff59;

  product58 <= delay_pipeline(57) * coeff58;

  product57 <= delay_pipeline(56) * coeff57;

  product56 <= delay_pipeline(55) * coeff56;

  product55 <= delay_pipeline(54) * coeff55;

  product54 <= delay_pipeline(53) * coeff54;

  product53 <= delay_pipeline(52) * coeff53;

  product52 <= delay_pipeline(51) * coeff52;

  product51 <= delay_pipeline(50) * coeff51;

  product50 <= delay_pipeline(49) * coeff50;

  product49 <= delay_pipeline(48) * coeff49;

  product48 <= delay_pipeline(47) * coeff48;

  product47 <= delay_pipeline(46) * coeff47;

  product46 <= delay_pipeline(45) * coeff46;

  product45 <= delay_pipeline(44) * coeff45;

  product44 <= delay_pipeline(43) * coeff44;

  product43 <= delay_pipeline(42) * coeff43;

  product42 <= delay_pipeline(41) * coeff42;

  product41 <= delay_pipeline(40) * coeff41;

  product40 <= delay_pipeline(39) * coeff40;

  product39 <= delay_pipeline(38) * coeff39;

  product38 <= delay_pipeline(37) * coeff38;

  product37 <= delay_pipeline(36) * coeff37;

  product36 <= delay_pipeline(35) * coeff36;

  product35 <= delay_pipeline(34) * coeff35;

  product34 <= delay_pipeline(33) * coeff34;

  product33 <= delay_pipeline(32) * coeff33;

  product32 <= delay_pipeline(31) * coeff32;

  product31 <= delay_pipeline(30) * coeff31;

  product30 <= delay_pipeline(29) * coeff30;

  product29 <= delay_pipeline(28) * coeff29;

  product28 <= delay_pipeline(27) * coeff28;

  product27 <= delay_pipeline(26) * coeff27;

  product26 <= delay_pipeline(25) * coeff26;

  product25 <= delay_pipeline(24) * coeff25;

  product24 <= delay_pipeline(23) * coeff24;

  product23 <= delay_pipeline(22) * coeff23;

  product22 <= delay_pipeline(21) * coeff22;

  product21 <= delay_pipeline(20) * coeff21;

  product20 <= delay_pipeline(19) * coeff20;

  product19 <= delay_pipeline(18) * coeff19;

  product18 <= delay_pipeline(17) * coeff18;

  product17 <= delay_pipeline(16) * coeff17;

  product16 <= delay_pipeline(15) * coeff16;

  product15 <= delay_pipeline(14) * coeff15;

  product14 <= delay_pipeline(13) * coeff14;

  product13 <= delay_pipeline(12) * coeff13;

  product12 <= delay_pipeline(11) * coeff12;

  product11 <= delay_pipeline(10) * coeff11;

  product10 <= delay_pipeline(9) * coeff10;

  product9 <= delay_pipeline(8) * coeff9;

  product8 <= delay_pipeline(7) * coeff8;

  product7 <= delay_pipeline(6) * coeff7;

  product6 <= delay_pipeline(5) * coeff6;

  product5 <= delay_pipeline(4) * coeff5;

  product4 <= delay_pipeline(3) * coeff4;

  product3 <= delay_pipeline(2) * coeff3;

  product2 <= delay_pipeline(1) * coeff2;

  product1_cast <= product1;


  product1 <= delay_pipeline(0) * coeff1;

  sum1 <= product1_cast + product2;

  sum2 <= sum1 + product3;

  sum3 <= sum2 + product4;

  sum4 <= sum3 + product5;

  sum5 <= sum4 + product6;

  sum6 <= sum5 + product7;

  sum7 <= sum6 + product8;

  sum8 <= sum7 + product9;

  sum9 <= sum8 + product10;

  sum10 <= sum9 + product11;

  sum11 <= sum10 + product12;

  sum12 <= sum11 + product13;

  sum13 <= sum12 + product14;

  sum14 <= sum13 + product15;

  sum15 <= sum14 + product16;

  sum16 <= sum15 + product17;

  sum17 <= sum16 + product18;

  sum18 <= sum17 + product19;

  sum19 <= sum18 + product20;

  sum20 <= sum19 + product21;

  sum21 <= sum20 + product22;

  sum22 <= sum21 + product23;

  sum23 <= sum22 + product24;

  sum24 <= sum23 + product25;

  sum25 <= sum24 + product26;

  sum26 <= sum25 + product27;

  sum27 <= sum26 + product28;

  sum28 <= sum27 + product29;

  sum29 <= sum28 + product30;

  sum30 <= sum29 + product31;

  sum31 <= sum30 + product32;

  sum32 <= sum31 + product33;

  sum33 <= sum32 + product34;

  sum34 <= sum33 + product35;

  sum35 <= sum34 + product36;

  sum36 <= sum35 + product37;

  sum37 <= sum36 + product38;

  sum38 <= sum37 + product39;

  sum39 <= sum38 + product40;

  sum40 <= sum39 + product41;

  sum41 <= sum40 + product42;

  sum42 <= sum41 + product43;

  sum43 <= sum42 + product44;

  sum44 <= sum43 + product45;

  sum45 <= sum44 + product46;

  sum46 <= sum45 + product47;

  sum47 <= sum46 + product48;

  sum48 <= sum47 + product49;

  sum49 <= sum48 + product50;

  sum50 <= sum49 + product51;

  sum51 <= sum50 + product52;

  sum52 <= sum51 + product53;

  sum53 <= sum52 + product54;

  sum54 <= sum53 + product55;

  sum55 <= sum54 + product56;

  sum56 <= sum55 + product57;

  sum57 <= sum56 + product58;

  sum58 <= sum57 + product59;

  sum59 <= sum58 + product60;

  sum60 <= sum59 + product61;

  sum61 <= sum60 + product62;

  sum62 <= sum61 + product63;

  sum63 <= sum62 + product64;

  sum64 <= sum63 + product65;

  sum65 <= sum64 + product66;

  sum66 <= sum65 + product67;

  sum67 <= sum66 + product68;

  sum68 <= sum67 + product69;

  sum69 <= sum68 + product70;

  sum70 <= sum69 + product71;

  sum71 <= sum70 + product72;

  sum72 <= sum71 + product73;

  sum73 <= sum72 + product74;

  sum74 <= sum73 + product75;

  sum75 <= sum74 + product76;

  sum76 <= sum75 + product77;

  sum77 <= sum76 + product78;

  sum78 <= sum77 + product79;

  sum79 <= sum78 + product80;

  sum80 <= sum79 + product81;

  sum81 <= sum80 + product82;

  sum82 <= sum81 + product83;

  sum83 <= sum82 + product84;

  sum84 <= sum83 + product85;

  sum85 <= sum84 + product86;

  sum86 <= sum85 + product87;

  sum87 <= sum86 + product88;

  sum88 <= sum87 + product89;

  sum89 <= sum88 + product90;

  sum90 <= sum89 + product91;

  sum91 <= sum90 + product92;

  sum92 <= sum91 + product93;

  sum93 <= sum92 + product94;

  sum94 <= sum93 + product95;

  sum95 <= sum94 + product96;

  sum96 <= sum95 + product97;

  sum97 <= sum96 + product98;

  sum98 <= sum97 + product99;

  sum99 <= sum98 + product100;

  sum100 <= sum99 + product101;

  Output_Register_process : PROCESS (clk, reset)
  BEGIN
    IF reset = '1' THEN
      output_register <= 0.0000000000000000E+00;
    ELSIF clk'event AND clk = '1' THEN
      IF clk_enable = '1' THEN
        output_register <= sum100;
      END IF;
    END IF; 
  END PROCESS Output_Register_process;

  -- Assignment Statements
  filter_out <= output_register;
END rtl;
