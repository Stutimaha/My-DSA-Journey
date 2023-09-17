<h2><a href="https://leetcode.com/problems/create-target-array-in-the-given-order/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Apple</div><div class="companyTagsContainer--tagOccurence">2</div></div><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Amazon</div><div class="companyTagsContainer--tagOccurence">2</div></div><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Visa</div><div class="companyTagsContainer--tagOccurence">1</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1389. Create Target Array in the Given Order</a></h2><h3>Easy</h3><hr><div><p>Given two arrays of integers&nbsp;<code>nums</code> and <code>index</code>. Your task is to create <em>target</em> array under the following rules:</p>

<ul>
	<li>Initially <em>target</em> array is empty.</li>
	<li>From left to right read nums[i] and index[i], insert at index <code>index[i]</code>&nbsp;the value <code>nums[i]</code>&nbsp;in&nbsp;<em>target</em> array.</li>
	<li>Repeat the previous step until there are no elements to read in <code>nums</code> and <code>index.</code></li>
</ul>

<p>Return the <em>target</em> array.</p>

<p>It is guaranteed that the insertion operations will be valid.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,2,3,4], index = [0,1,2,2,1]
<strong>Output:</strong> [0,4,1,3,2]
<strong>Explanation:</strong>
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,4,0], index = [0,1,2,3,0]
<strong>Output:</strong> [0,1,2,3,4]
<strong>Explanation:</strong>
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1], index = [0]
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length, index.length &lt;= 100</code></li>
	<li><code>nums.length == index.length</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>0 &lt;= index[i] &lt;= i</code></li>
</ul>
</div>