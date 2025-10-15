#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int sum;
	std::cin >> sum;

	int n;
	std::cin >> n;
	
	while (n--) {
		char opeator;
		int a;
		std::cin >> opeator >> a;
		sum += (opeator == '+' ? a : -a);
	}
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}