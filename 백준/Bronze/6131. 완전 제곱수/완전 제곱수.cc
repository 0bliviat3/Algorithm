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
	int a = 1;
	int b = 1;
	int cnt = 0;
	while (a <= 500) {
		if (a * a - b * b == n) {
			cnt++;
		}
		if (a * a - b * b > n) {
			b++;
			if (b == a) {
				a++;
				b = 1;
			}
		} else {
			a++;
		}
	}

	std::cout << cnt;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}