#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	int n;
	std::cin >> n;

	int cnt = 0;
	char pre;
	std::cin >> pre;
	n--;
	while (n--) {
		char now;
		std::cin >> now;
		int diff = std::abs(pre - now);
		if (diff == 1) {
			cnt++;
			if (cnt == 4) {
				std::cout << "YES";
				return;
			}
		} else {
			cnt = 0;
		}
		pre = now;
	}
	std::cout << "NO";


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}