#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;

	int awin = 0, bwin = 0;

	while (n--) {
		int a, b;
		std::cin >> a >> b;
		if (a > b) {
			awin++;
		} else if (a < b) {
			bwin++;
		}
	}

	std::cout << awin << " " << bwin;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}