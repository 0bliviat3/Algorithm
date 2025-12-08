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

	int sum = 0;
	int bonus = 0;

	for (int i = 1; i <= n; i++) {
		char c;
		std::cin >> c;
		if (c == 'O') {
			sum += bonus++;
			sum += i;
		} else {
			bonus = 0;
		}
	}

	std::cout << sum;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}