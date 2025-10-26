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

	int total = 0;
	while (n--) {
		int sum = 0;
		for (int i = 0; i < 13; i++) {
			char c;
			std::cin >> c;
			switch (c)
			{
			case 'A':
				sum += 4;
				break;
			case 'K':
				sum += 3;
				break;
			case 'Q':
				sum += 2;
				break;
			case 'J':
				sum += 1;
				break;
			default:
				break;
			}
		}
		total += sum;
	}
	std::cout << total;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}