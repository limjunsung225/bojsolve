# [Silver V] Step Aerobics - 22428 

[문제 링크](https://www.acmicpc.net/problem/22428) 

### 성능 요약

메모리: 31256 KB, 시간: 44 ms

### 분류

구현

### 문제 설명

<p>JAG大学に通う一樹君，通称カー君は，この夏友達であるあなたに誘われて，ICPC (International Collegiate Potchari Contest) に出場することになった． ICPCは，スポーツ系のコンテストであり，高度な運動能力が必要とされる． しかし，カー君はいつもパソコンの前にいてばかりで，少し動くだけでも疲れてしまうほどに運動不足だった． そこでカー君は，ICPCでいい成績を残すための第1ステップとして，手軽に始められる運動，「踏み台昇降」を始めることにした．</p>

<p>踏み台昇降とは，その名の通り，踏み台と床との上り下りをただひたすら繰り返すだけの単純な運動である． ただし，踏み台昇降では，正しい足の昇降を行わなければ，その効果を得ることはできない． 正しい昇降とは，以下の2種類の内いずれかを満たす足の動きである．</p>

<ul>
	<li>両足が床についた状態から，左足と右足を踏み台の上に上げて，踏み台の上に両足ともついた状態になる．左足と右足どちらを先に上げてもよい．</li>
	<li>踏み台の上に両足ともついた状態から，左足と右足を床に下げて，両足が床についた状態になる．左足と右足どちらを先に下げてもよい．</li>
</ul>

<p>以上からわかるように，床または踏み台の上にいる状態から連続で片足だけを上げ下げしても，正しい昇降とはならない． 踏み台昇降運動では，上記の正しい昇降の動きのいずれかを満たすとき，1回とカウントし，そのカウント数が大きければ大きいほど，効果を得ることができる． 床と踏み台を往復しなくても，片道だけで1回とカウントすることに注意してほしい．</p>

<p>あなたは，チームメイトであるカー君に少しでも強くなってほしいと考えている． そこであなたは，カー君が踏み台昇降をさぼっていないか，プログラムを書いてチェックしてあげることにした． カー君が踏み台昇降で動かした足の情報が与えられるので，正しく昇降を行った回数を求めよ． ただし，<b>両足とも床についている状態から踏み台昇降を始める</b>ものとする．</p>

### 입력 

 <p>入力は，複数のデータセットから構成され，1つの入力に含まれるデータセットの数は150以下である． 各データセットの形式は次の通りである．</p>

<blockquote>
<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span> </mjx-container></p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D453 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em; margin-left: -0.06em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>f</mi><mn>1</mn></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$f_1$</span></mjx-container> <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D453 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em; margin-left: -0.06em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>f</mi><mn>2</mn></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$f_2$</span></mjx-container> ... <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D453 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em; margin-left: -0.06em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>f</mi><mi>n</mi></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$f_n$</span> </mjx-container></p>
</blockquote>

<p>1行目で，足を動かした回数を表す整数 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container> (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>n</mi><mo>≤</mo><mn>100</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \le n \le 100$</span></mjx-container>) が与えられる． 2行目で，足の動作を表す文字列である <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D453 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em; margin-left: -0.06em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>f</mi><mi>i</mi></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$f_i$</span></mjx-container> が時系列順に <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container> 個，スペース区切りで与えられる． <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D453 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em; margin-left: -0.06em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>f</mi><mi>i</mi></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$f_i$</span></mjx-container> は，以下の4種類の文字列の内いずれかである．</p>

<ul>
	<li>"<samp>lu</samp>" : 左足を踏み台へ上げる．</li>
	<li>"<samp>ru</samp>" : 右足を踏み台へ上げる．</li>
	<li>"<samp>ld</samp>" : 左足を床へ下げる．</li>
	<li>"<samp>rd</samp>" : 右足を床へ下げる．</li>
</ul>

<p>床についている足をさらに下げるような動作や，踏み台についている足をさらに上げるような動作は入力されないと仮定してよい．</p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container> が0の行は入力の終わりを表す．このデータについては処理を行ってはならない．</p>

### 출력 

 <p>各データセットに対して，1行で正しい踏み台昇降を行った回数を出力せよ． 各行の終わりに改行を出力しない場合や，不必要な文字を出力する場合，誤答と判断されてしまうため注意すること．</p>

