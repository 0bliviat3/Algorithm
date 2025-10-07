#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	int cnt = 0;
	while (std::cin >> n) {
		if (n > 0) {
			cnt++;
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