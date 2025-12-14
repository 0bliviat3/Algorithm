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

	while (n--) {
		int a, b;
		std::cin >> a >> b;
		std::vector<bool> arr(b);
		int cnt = 0;
		while (a--) {
			int c;
			std::cin >> c;
			if (!arr[c - 1]) {
				arr[c - 1] = true;
			}
			else {
				cnt++;
			}
			
		}
		std::cout << cnt << "\n";
	}


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}