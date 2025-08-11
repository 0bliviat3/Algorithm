#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	double k, d1, d2;
	std::cin >> k >> d1 >> d2;

	std::cout << k * k - pow((d1 - d2) / 2.0, 2);
	 
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}