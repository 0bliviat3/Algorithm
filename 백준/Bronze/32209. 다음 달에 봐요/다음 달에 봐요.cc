#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;
	
	int p = 0;
	while (n--) {
		int no, q;
		std::cin >> no >> q;
		if (no == 1) {
			p += q;
		} else {
			p -= q;
		}
		if (p < 0) {
			break;
		}
	}
	if (p < 0) {
		std::cout << "Adios";
	} else {
		std::cout << "See you next month";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}